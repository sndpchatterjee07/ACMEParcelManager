package com.teamsuccesso.www.assignmentOne.service;

import java.io.InputStream;
import java.util.List;

import com.teamsuccesso.www.assignmentOne.core.Parcel;

/**
 * The Interface Addressable.
 * 
 * @author sandeep
 */
public interface Addressable {
	
	/**
	 * Gets the parcel list.
	 *
	 * @param inputStream the input stream
	 * @return the parcel list
	 */
	public List<Parcel> getParcelList(InputStream inputStream);

}
