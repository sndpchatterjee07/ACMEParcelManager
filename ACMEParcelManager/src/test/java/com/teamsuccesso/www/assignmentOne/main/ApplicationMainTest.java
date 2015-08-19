package com.teamsuccesso.www.assignmentOne.main;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The Class ApplicationMainTest.
 * 
 * @author sandeep
 */
public class ApplicationMainTest {

	/** The Constant APPLICATION_MAIN. */
	private static final ApplicationMain APPLICATION_MAIN = new ApplicationMain();

	/*
	 * Test with as many records as possible. this file is located under
	 * "/src/test/resources/"
	 */
	private static final String inputResourcePathHaving20Entries = "/TEST_InputResourceForUnitTestWith20Entries.txt";

	private static final String inputResourcePathHavingMoreThan1000Entries = "/TEST_InputResourceForUnitTestWithMoreThan1000Entries.txt";

	private static final int limitBy = 3;

	private static final String outputPath = "/home/sandeep/Desktop/MyDocs/repos/git-repos/public/ACMEParcelManager/ACMEParcelManager/src/test/resources/TEST_Output.txt";

	private static final Map<String, Integer> finalMapForWritingToFileFor20Entries = APPLICATION_MAIN
			.getFinalRankwisePostalCodeMapByDeliveryCount(APPLICATION_MAIN.getSortedEntries(
					APPLICATION_MAIN
							.getParcelManager()
							.getParcelList(
									APPLICATION_MAIN
											.getInputResource(inputResourcePathHaving20Entries)),
					limitBy));

	@SuppressWarnings("unused")
	private static final Map<String, Integer> finalMapForWritingToFileForMoreThan1000Entries = APPLICATION_MAIN
			.getFinalRankwisePostalCodeMapByDeliveryCount(APPLICATION_MAIN.getSortedEntries(
					APPLICATION_MAIN
							.getParcelManager()
							.getParcelList(
									APPLICATION_MAIN
											.getInputResource(inputResourcePathHavingMoreThan1000Entries)),
					limitBy));

	/**
	 * ALL TESTS FOR METHOD 1 - getFileLoader()
	 */
	@Test
	public void testGetFileLoaderIsNotNull() {
		Assert.assertNotNull(APPLICATION_MAIN.getFileLoader());
	}

	/**
	 * ALL TESTS FOR METHOD 2 - getParcelManager()
	 */
	@Test
	public void testGetParcelManagerIsNotNull() {
		Assert.assertNotNull(APPLICATION_MAIN.getParcelManager());
	}

	/**
	 * ALL TESTS FOR METHOD 3 - getInputResource()
	 */
	@Test
	public void testGetInputResourceIsNotNullFor20Entries() {
		Assert.assertNotNull(APPLICATION_MAIN
				.getInputResource(inputResourcePathHaving20Entries));

	}

	@Test
	public void testGetInputResourceIsNotNullForMoreThan1000Entries() {
		Assert.assertNotNull(APPLICATION_MAIN
				.getInputResource(inputResourcePathHavingMoreThan1000Entries));
	}

	/**
	 * ALL TESTS FOR METHOD 4 - requestOutputPath()
	 * 
	 */
	@Test
	public void testRequestOutputPathIsNotNull() {
		Assert.assertNotNull(APPLICATION_MAIN.requestOutputPath(outputPath));
	}

	/**
	 * ALL TESTS FOR METHOD 5 - requestLimitBy()
	 * 
	 */
	@Test
	public void testRequestLimitByIsThree() {
		Assert.assertEquals(3, APPLICATION_MAIN.requestLimitBy(limitBy));
	}

	/**
	 * ALL TESTS FOR METHOD 6 - getParcels()
	 */
	@Test
	public void testGetParcelsIsNotNullAndListSizeEquals20For20Entries() {
		Assert.assertNotNull(APPLICATION_MAIN.getParcels(APPLICATION_MAIN
				.getInputResource(inputResourcePathHaving20Entries)));
		Assert.assertEquals(
				20,
				APPLICATION_MAIN
						.getParcels(
								APPLICATION_MAIN
										.getInputResource(inputResourcePathHaving20Entries))
						.size());
	}

	@Test
	public void testGetParcelsIsNotNullAndListSizeEquals1007ForMoreThan1000Entries() {
		Assert.assertNotNull(APPLICATION_MAIN.getParcels(APPLICATION_MAIN
				.getInputResource(inputResourcePathHavingMoreThan1000Entries)));
		Assert.assertEquals(
				1007,
				APPLICATION_MAIN
						.getParcels(
								APPLICATION_MAIN
										.getInputResource(inputResourcePathHavingMoreThan1000Entries))
						.size());
	}

	/**
	 * ALL TESTS FOR METHOD 7 - doInitialize(): Ignore this test case.
	 */
	@Ignore
	public void testDoInitialize() {
		// Ignore.
	}

	/**
	 * ALL TESTS FOR METHOD 8 - getSortedEntries()
	 */
	@Test
	public void testGetSortedEntriesIsNotNullAndNotEmptyAndReturnsExactThreeSortedEntriesFor20Entries() {
		Assert.assertNotNull(APPLICATION_MAIN.getSortedEntries(
				APPLICATION_MAIN
						.getParcelManager()
						.getParcelList(
								APPLICATION_MAIN
										.getInputResource(inputResourcePathHaving20Entries)),
				limitBy));
		Assert.assertFalse(APPLICATION_MAIN
				.getSortedEntries(
						APPLICATION_MAIN
								.getParcelManager()
								.getParcelList(
										APPLICATION_MAIN
												.getInputResource(inputResourcePathHaving20Entries)),
						limitBy).isEmpty());
		Assert.assertEquals(
				3,
				APPLICATION_MAIN
						.getSortedEntries(
								APPLICATION_MAIN
										.getParcelManager()
										.getParcelList(
												APPLICATION_MAIN
														.getInputResource(inputResourcePathHaving20Entries)),
								limitBy).size());
	}

	@Test
	public void testGetSortedEntriesIsNotNullAndNotEmptyAndReturnsExactThreeSortedEntriesForMoreThan1000Entries() {

		Assert.assertNotNull(APPLICATION_MAIN.getSortedEntries(
				APPLICATION_MAIN
						.getParcelManager()
						.getParcelList(
								APPLICATION_MAIN
										.getInputResource(inputResourcePathHavingMoreThan1000Entries)),
				limitBy));
		Assert.assertFalse(APPLICATION_MAIN
				.getSortedEntries(
						APPLICATION_MAIN
								.getParcelManager()
								.getParcelList(
										APPLICATION_MAIN
												.getInputResource(inputResourcePathHavingMoreThan1000Entries)),
						limitBy).isEmpty());
		Assert.assertEquals(
				3,
				APPLICATION_MAIN
						.getSortedEntries(
								APPLICATION_MAIN
										.getParcelManager()
										.getParcelList(
												APPLICATION_MAIN
														.getInputResource(inputResourcePathHavingMoreThan1000Entries)),
								limitBy).size());

	}

	/**
	 * ALL TESTS FOR METHOD 9 - getFinalRankwisePostalCodeMapByDeliveryCount()
	 */
	@Test
	public void testGetFinalRankwisePostalCodeMapByDeliveryCountFor20Entries() {

		Map<String, Integer> expectedMapForWritingToFileFor20Entries = new LinkedHashMap<String, Integer>();
		expectedMapForWritingToFileFor20Entries.put("456098", 6);
		expectedMapForWritingToFileFor20Entries.put("567789", 5);
		expectedMapForWritingToFileFor20Entries.put("560089", 3);

		Assert.assertNotNull(finalMapForWritingToFileFor20Entries);
		Assert.assertEquals(expectedMapForWritingToFileFor20Entries,
				finalMapForWritingToFileFor20Entries);
	}
}
