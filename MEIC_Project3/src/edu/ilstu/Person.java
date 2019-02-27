/*
 * File name: Person.java
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
 * Person template, lists off name, and sets up for doctor/patient
 *
 * @author Matthew Caparoon
 *
 */
public abstract class Person
{
	private String firstName;
	private String middleInitial;
	private String lastName;
	
	/**
	 * General constructor for the Person class
	 */
	public Person()
	{
		
	}
	
	/**
	 * Constructor for the Person class
	 * @param firstName
	 * @param midleInitial
	 * @param lastName
	 */
	public Person(String firstName, String middleInitial, String lastName)
	{
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
	}

	/**
	 * getter for firstName
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * setter for firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * getter for middle initial
	 * @return
	 */
	public String getMiddleInitial()
	{
		return middleInitial;
	}

	/**
	 * getter for middle initial
	 * @param middleInitial
	 */
	public void setMiddleInitial(String middleInitial)
	{
		this.middleInitial = middleInitial;
	}

	/**
	 * getter for last name
	 * @return
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * setter for last name
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * cookie-cutter toString
	 */
	@Override
	public abstract String toString();
}
