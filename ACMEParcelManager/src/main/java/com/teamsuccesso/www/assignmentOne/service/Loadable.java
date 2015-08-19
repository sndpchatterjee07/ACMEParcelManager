package com.teamsuccesso.www.assignmentOne.service;

import java.io.InputStream;

/**
 * The Interface Loadable.
 * 
 * @author sandeep
 */
public interface Loadable {

	/**
	 * Load resource.
	 *
	 * @param resourcePath
	 *            the resource path to load
	 * @return the input stream to return
	 */
	public InputStream loadResource(String resourcePath);

}
