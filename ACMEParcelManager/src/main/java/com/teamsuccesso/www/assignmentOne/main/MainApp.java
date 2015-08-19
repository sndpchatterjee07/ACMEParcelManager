package com.teamsuccesso.www.assignmentOne.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.teamsuccesso.www.assignmentOne.core.Parcel;
import com.teamsuccesso.www.assignmentOne.service.FileLoader;
import com.teamsuccesso.www.assignmentOne.service.ParcelManager;

/**
 * Main Application.
 * 
 * @author sandeep
 */
public class MainApp {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		FileLoader fileLoader = FileLoader.getInstance();

		ParcelManager parcelManager = ParcelManager.getInstance();

		/* Load the resource. */
		InputStream inputStream = fileLoader.getClass().getResourceAsStream(
				"/Input.txt");

		/* Output path. */
		final String outputPath = "/home/sandeep/Desktop/MyDocs/repos/git-repos/public/ACMEParcelManager/ACMEParcelManager/src/main/resources/Output.txt";

		/* Total number of listings to write. */
		final int limitBy = 3;

		/* Get the parcellist from the inputstream. */
		List<Parcel> parcels = parcelManager.getParcelList(inputStream);

		/* The map of ranked Postal Codes. */
		Map<String, Integer> rankedPostalCodes = new LinkedHashMap<String, Integer>();

		/* The File writer. */
		FileWriter fileWriter = null;

		/* The Buffered writer. */
		BufferedWriter bufferedWriter = null;

		/*
		 * Sort the parcel list, group by postal code and get list of top 3
		 * entries.
		 */
		List<Entry<String, List<Parcel>>> sortedEntries = parcelManager
				.sortParcelListGroupByPostalCode(parcels, limitBy);

		/* Get the final rankwise map of postalcodes by maximum delivery count. */
		rankedPostalCodes = parcelManager
				.rankPostalCodeByMaxDeliveryCount(sortedEntries);

		/* Write the map to file and close streams. */

		try {
			fileWriter = new FileWriter(outputPath);
			bufferedWriter = new BufferedWriter(fileWriter);
			parcelManager.writeRankedPostalCodesToFile(limitBy, outputPath,
					rankedPostalCodes, bufferedWriter);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DONE. Output written to "+outputPath+"!");
	}
}
