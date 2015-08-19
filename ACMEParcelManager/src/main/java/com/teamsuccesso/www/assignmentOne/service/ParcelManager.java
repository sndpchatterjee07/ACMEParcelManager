package com.teamsuccesso.www.assignmentOne.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.teamsuccesso.www.assignmentOne.core.Parcel;

/**
 * The Class ParcelManager.
 * 
 * @author sandeep
 */
public class ParcelManager implements Addressable, Sortable, ACMEWriter {

	/** The Constant PARCEL_MANAGER_INSTANCE. */
	private static final ParcelManager PARCEL_MANAGER_INSTANCE = new ParcelManager();

	/** The list of parcels. */
	private List<Parcel> parcels;

	/**
	 * Instantiates a new parcel manager.
	 */
	private ParcelManager() {
		if (PARCEL_MANAGER_INSTANCE != null) {
			throw new IllegalStateException("Already instantiated!");
		}
	}

	/**
	 * Gets the single instance of ParcelManager.
	 *
	 * @return single instance of ParcelManager
	 */
	public static ParcelManager getInstance() {
		return PARCEL_MANAGER_INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teamsuccesso.www.assignmentOne.service.Addressable#getParcelList(
	 * java.io.InputStream)
	 */
	@Override
	public List<Parcel> getParcelList(InputStream inputStream) {

		Parcel parcel;

		parcels = new ArrayList<Parcel>();

		List<String> parcelList = new BufferedReader(new InputStreamReader(
				inputStream, StandardCharsets.UTF_8)).lines().collect(
				Collectors.toList());

		Iterator<String> iterator = parcelList.listIterator();

		while (iterator.hasNext()) {
			Pattern postalCodePattern = Pattern.compile("(\\d{6})");
			Matcher postalCodeMatcher = postalCodePattern.matcher(iterator
					.next());
			if (postalCodeMatcher.find()) {
				String postalCode = postalCodeMatcher.group(1);
				parcel = new Parcel();

				// Populate parcel bean
				parcel.setParcelId(new BigInteger(256, new Random()));
				parcel.setPostalCode(postalCode);
				parcels.add(parcel);
			}
		}
		return parcels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teamsuccesso.www.assignmentOne.service.Sortable#
	 * sortParcelListGroupByPostalCode(java.util.List, int)
	 */
	@Override
	public List<Entry<String, List<Parcel>>> sortParcelListGroupByPostalCode(
			List<Parcel> parcels, int limitBy) {

		return parcels
				.stream()
				.collect(Collectors.groupingBy(p -> p.getPostalCode()))
				.entrySet()
				.stream()
				.sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1
						.getValue().size())).limit(limitBy) // Top N
				.collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teamsuccesso.www.assignmentOne.service.Sortable#
	 * rankPostalCodeByMaxDeliveryCount(java.util.List)
	 */
	@Override
	@SuppressWarnings("unused")
	public Map<String, Integer> rankPostalCodeByMaxDeliveryCount(
			List<Entry<String, List<Parcel>>> sortedEntries) {
		Map<String, Integer> rankedPostalCodes = new LinkedHashMap<String, Integer>();

		for (Entry<String, List<Parcel>> entry : sortedEntries) {
			int occurences = 0;
			// System.out.print("Key(" + entry.getKey()+")");
			for (Parcel value : entry.getValue()) {
				// System.out.println("    Value = " + value);
				occurences++;
			}
			rankedPostalCodes.put(entry.getKey(), occurences);
			// System.out.println(" -> Occurences("+occurences+")");
			occurences = 0;
		}

		return rankedPostalCodes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teamsuccesso.www.assignmentOne.service.ACMEWriter#
	 * writeRankedPostalCodesToFile(int, java.lang.String, java.util.Map,
	 * java.io.BufferedWriter)
	 */
	@Override
	public void writeRankedPostalCodesToFile(int recordsToWrite,
			String outputPath, Map<String, Integer> rankedPostalCodes,
			BufferedWriter bufferedWriter) throws IOException {

		Iterator<Entry<String, Integer>> iterator = null;
		
		try {

			/* Initialise variables */
			int count = 0, temp = 1;

			iterator = rankedPostalCodes.entrySet().iterator();

			/* Write header */
			bufferedWriter.write("#" + "\t" + "PINCODE" + "\t" + "RANK" + "\t"
					+ "No of Parcels Delivered" + "\n");

			while (iterator.hasNext() && count < recordsToWrite) {
				Entry<String, Integer> postalCodeDeliveryCountPairs = iterator
						.next();
				bufferedWriter.write(temp + "\t"
						+ postalCodeDeliveryCountPairs.getKey() + "\t" + temp
						+ "\t\t\t\t" + postalCodeDeliveryCountPairs.getValue()
						+ "\n");
				temp = temp +1;
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(e);
		} finally {
			bufferedWriter.close();
		}

	}

}
