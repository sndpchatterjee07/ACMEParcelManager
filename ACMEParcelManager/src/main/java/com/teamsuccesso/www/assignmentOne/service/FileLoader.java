package com.teamsuccesso.www.assignmentOne.service;

import java.io.InputStream;

/**
 * The Class FileLoader.
 * 
 * @author sandeep
 */
public final class FileLoader implements Loadable {

	/** The Constant FILE_LOADER_INSTANCE. */
	private static final FileLoader FILE_LOADER_INSTANCE = new FileLoader();

	/**
	 * Instantiates a new file loader.
	 */
	private FileLoader() {
		if (FILE_LOADER_INSTANCE != null) {
			throw new IllegalStateException("Already instantiated!");
		}
	}

	/**
	 * Gets the single instance of FileLoader.
	 *
	 * @return single instance of FileLoader
	 */
	public static FileLoader getInstance() {
		return FILE_LOADER_INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teamsuccesso.www.assignmentOne.service.Loadable#loadResource(java
	 * .lang.String)
	 */
	@Override
	public InputStream loadResource(String resourcePath) {

		return FileLoader.class.getResourceAsStream(resourcePath);

	}

}
