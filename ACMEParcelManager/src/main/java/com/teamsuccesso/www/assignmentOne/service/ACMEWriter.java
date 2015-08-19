package com.teamsuccesso.www.assignmentOne.service;

import java.io.BufferedWriter;
import java.util.Map;

/**
 * The Interface ACMEWriter.
 * 
 * @author sandeep
 */
public interface ACMEWriter {
	
	
	/**
	 * Write ranked postal codes to file.
	 *
	 * @param recordsToWrite number of records to write
	 * @param outputPath the output path
	 * @param rankedPostalCodes the ranked postal codes
	 * @param bufferedWriter the buffered writer
	 * @throws Exception the exception
	 */
	public void writeRankedPostalCodesToFile(int recordsToWrite, String outputPath, Map<String, Integer> rankedPostalCodes, BufferedWriter bufferedWriter) throws Exception;

}
