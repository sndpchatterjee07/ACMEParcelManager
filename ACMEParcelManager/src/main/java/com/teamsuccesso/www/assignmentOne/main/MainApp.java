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

		/* 1. Get FileLoader instance */
		FileLoader fileLoader = FileLoader.getInstance();

		/* 2. Get Parcel Manager instance */
		ParcelManager parcelManager = ParcelManager.getInstance();

		/* 3. Load the resource. */

		InputStream inputStream = fileLoader.getClass().getResourceAsStream(
				"/SRC_InputResourceForUnitTestWith20Entries.txt");

		@SuppressWarnings("unused")
		InputStream inputStream_1 = fileLoader.getClass().getResourceAsStream(
				"/SRC_InputResourceForUnitTestWithMoreThan1000Entries.txt");

		/*
		 * 4. Output path.
		 * 
		 * Please change this to your desired location to avoid any exception. 
		 * For example: final String outputPath = "/home/sandeep/Desktop/Output.txt";
		 */
		final String outputPath = "/home/sandeep/Desktop/MyDocs/repos/git-repos/public/ACMEParcelManager/ACMEParcelManager/src/main/resources/Output.txt";

		/* 5. Total number of listings to write. */
		final int limitBy = 3;

		/* 6. Get the parcellist from the inputstream. */
		if (inputStream != null) {
			List<Parcel> parcels = parcelManager.getParcelList(inputStream);

			/* 7a. The map of ranked Postal Codes. */
			Map<String, Integer> rankedPostalCodes = new LinkedHashMap<String, Integer>();

			/* 7b. The File writer. */
			FileWriter fileWriter = null;

			/* 7c. The Buffered writer. */
			BufferedWriter bufferedWriter = null;

			/*
			 * 8. Sort the parcel list, group by postal code and get list of top
			 * 3 entries.
			 */
			List<Entry<String, List<Parcel>>> sortedEntries = parcelManager
					.sortParcelListGroupByPostalCode(parcels, limitBy);

			/*
			 * 9. Get the final rankwise map of postalcodes by maximum delivery
			 * count.
			 */
			rankedPostalCodes = parcelManager
					.rankPostalCodeByMaxDeliveryCount(sortedEntries);

			/* 10. Write the map to file and close streams. */

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
			System.out.println("DONE. Output written to " + outputPath + "!");
		} else {
			System.out
					.println("OOPS....PROBLEM RETRIEVING PARCELS FROM INPUTSTREAM!!!");
		}
	}
}
