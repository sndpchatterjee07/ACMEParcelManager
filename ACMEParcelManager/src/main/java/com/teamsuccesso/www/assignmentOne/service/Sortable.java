package com.teamsuccesso.www.assignmentOne.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.teamsuccesso.www.assignmentOne.core.Parcel;

/**
 * The Interface Sortable.
 * 
 * @author sandeep
 */
public interface Sortable {

	/**
	 * Sort parcle list group by postal code.
	 *
	 * @param parcels
	 *            the list of parcels
	 * @param limitBy
	 *            the limit by
	 * @return the list
	 */
	public List<Entry<String, List<Parcel>>> sortParcelListGroupByPostalCode(
			List<Parcel> parcels, int limitBy);

	/**
	 * Rank postal code by max delivery count.
	 *
	 * @param entries
	 *            the entries
	 * @return the map
	 */
	public Map<String, Integer> rankPostalCodeByMaxDeliveryCount(
			List<Entry<String, List<Parcel>>> entries);

}
