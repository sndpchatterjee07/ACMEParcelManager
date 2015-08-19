package com.teamsuccesso.www.assignmentOne.core;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

/**
 * The Class ParcelTest - All tests for class Parcel.
 * 
 * @author sandeep
 * @see http://www.jqno.nl/equalsverifier/
 * @see https://github.com/jqno/equalsverifier/blob/master/README.md
 * 
 */
public class ParcelTest {

	/**
	 * Test to verify whether the contract for the equals and hashCode methods
	 * is met.
	 * 
	 * @see http://www.jqno.nl/equalsverifier/documentation/
	 */
	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(Parcel.class)
				.suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
				.verify();
	}
}
