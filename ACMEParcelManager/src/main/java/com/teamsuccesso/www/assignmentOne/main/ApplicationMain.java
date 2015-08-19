package com.teamsuccesso.www.assignmentOne.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.teamsuccesso.www.assignmentOne.core.Parcel;
import com.teamsuccesso.www.assignmentOne.service.FileLoader;
import com.teamsuccesso.www.assignmentOne.service.ParcelManager;

/**
 * The Class ApplicationMain - All functional code of class MainApp has been
 * moved/kept here for Unit Testing purposes.
 * 
 * 
 * @author sandeep
 */
public class ApplicationMain {

	/**
	 * METHOD 1: Gets the file loader.
	 *
	 * @return single instance of FileLoader
	 */
	public FileLoader getFileLoader() {

		return FileLoader.getInstance();
	}

	/**
	 * METHOD 2: Gets the parcel manager.
	 *
	 * @return single instance of ParcelManager
	 */
	public ParcelManager getParcelManager() {

		return ParcelManager.getInstance();
	}

	/**
	 * METHOD 3: Gets the input resource.
	 *
	 * @param resourcePath
	 *            the resource path
	 * @return the input resource
	 */
	public InputStream getInputResource(String resourcePath) {

		return FileLoader.getInstance().getClass()
				.getResourceAsStream(resourcePath);
	}

	/**
	 * METHOD 4: Request output path - where should the file be written?
	 *
	 * @param outputPath
	 *            the output path
	 * @return the string
	 */
	public String requestOutputPath(String outputPath) {
		return outputPath;
	}

	/**
	 * METHOD 5: Request limit by - How many records needs to be written to the
	 * output file?
	 *
	 * @param limitBy
	 *            the limit by
	 * @return the int
	 */
	public int requestLimitBy(int limitBy) {
		return limitBy;
	}

	/**
	 * METHOD 6: Get the parcellist from the inputstream.
	 *
	 * @param inputStream
	 *            the input stream
	 * @return the parcels
	 */
	public List<Parcel> getParcels(InputStream inputStream) {
		return this.getParcelManager().getParcelList(inputStream);
	}

	/**
	 * METHOD 7: Variable initializations - See comments 7a, 7b and 7c in
	 * MainApp.java
	 * 
	 * No need to test this method - test case has been annotated with @Ignore.
	 */
	@SuppressWarnings("unused")
	public void doInitialize() {
		Map<String, Integer> rankedPostalCodes = new LinkedHashMap<String, Integer>();
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
	}

	/**
	 * METHOD 8: Sort the parcel list, group by postal code and get list of top
	 * 3 entries.
	 *
	 * @param parcels
	 *            the parcels
	 * @param limitBy
	 *            the limit by
	 * @return the sorted entries
	 */
	public List<Entry<String, List<Parcel>>> getSortedEntries(
			List<Parcel> parcels, int limitBy) {
		return this.getParcelManager().sortParcelListGroupByPostalCode(parcels,
				limitBy);
	}

	/**
	 * METHOD 9: Get the final rankwise map of postalcodes by maximum delivery
	 *
	 * @param sortedEntries
	 *            the sorted entries
	 * @return the final rankwise postal code map by delivery count
	 */
	public Map<String, Integer> getFinalRankwisePostalCodeMapByDeliveryCount(
			List<Entry<String, List<Parcel>>> sortedEntries) {
		return this.getParcelManager().rankPostalCodeByMaxDeliveryCount(
				sortedEntries);
	}

}
