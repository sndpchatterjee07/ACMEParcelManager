package com.teamsuccesso.www.assignmentOne.core;

import java.math.BigInteger;
import com.google.common.base.Objects;

/**
 * The bean Parcel.
 * 
 * @author sandeep
 */
public class Parcel {

	/** The unique parcel id for every object of this type. */
	private BigInteger parcelId;

	/** The name. */
	private String name;

	/** The address. */
	private String address;

	/** The contact no. */
	private String contactNo;

	/** The postal code. */
	private String postalCode;

	// Object overrides.

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return "PARCEL ID ##" + parcelId + ", POSTAL CODE: " + postalCode;
		//return parcelId + "->" + postalCode;
		return postalCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return Objects.hashCode(parcelId);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(Object object) {
		if (object instanceof Parcel) {
			Parcel that = (Parcel) object;
			return Objects.equal(this.parcelId, that.parcelId);
		}
		return false;
	}

	// Accessors and mutators
	public BigInteger getParcelId() {
		return parcelId;
	}

	public void setParcelId(BigInteger parcelId) {
		this.parcelId = parcelId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the contact no.
	 *
	 * @return the contact no
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * Sets the contact no.
	 *
	 * @param contactNo
	 *            the new contact no
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode
	 *            the new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
