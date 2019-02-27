/*
 * File name: Doctor.java
 *
 * Programmer: Matthew Caparoon
 * ULID: mcaparo
 *
 * Date: Mar 1, 2016
 *
 * Class: IT 179
 * Lecture Section: 034
 * Lecture Instructor: Holbrook
 */
package edu.ilstu;

/**
 * Doctor extension to the Person Class
 *
 * @author Matthew Caparoon
 *
 */
public class Doctor extends Person
{
	private Specialty spec;
	private double fee;
	
	/**
	 * Constructor for the Doctor class
	 * @param firstName
	 * @param middleInitial
	 * @param lastName
	 * @param spec
	 * @param fee
	 */
	public Doctor(String firstName, String middleInitial, String lastName, Specialty spec, double fee)
	{
		super(firstName, middleInitial, lastName);
		this.fee = fee;
		this.spec = spec;
	}

	/**
	 * getter for specialty
	 * @return
	 */
	public Specialty getSpec()
	{
		return spec;
	}

	/**
	 * setter for specialty
	 * @param spec
	 */
	public void setSpec(Specialty spec)
	{
		this.spec = spec;
	}

	/**
	 * getter for fee
	 * @return
	 */
	public double getFee()
	{
		return fee;
	}

	/**
	 * setter for fee
	 * @param fee
	 */
	public void setFee(double fee)
	{
		this.fee = fee;
	}

	@Override
	public String toString()
	{
		String docReturn = "Doctor: " + getFirstName() + " " + getMiddleInitial() + " " + getLastName() + ", " 
				+ getSpec();
		return docReturn;
	}
	
}
