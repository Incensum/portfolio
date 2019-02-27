/*
 * File name: Patient.java
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
 * Patient extension on the Person class
 *
 * @author Matthew Caparoon
 *
 */
public class Patient extends Person implements Insurable
{
	private String id;
	private String birthDate;
	private InsuranceType insur;
	
	/**
	 * Constructor for the Patient class
	 * @param firstName
	 * @param middleInitial
	 * @param lastName
	 * @param id
	 * @param birthDate
	 * @param insur
	 */
	public Patient(String firstName, String middleInitial, String lastName, String id, String birthDate, InsuranceType insur)
	{
		super(firstName, middleInitial, lastName);
		this.id = id;
		this.birthDate = birthDate;
		this.insur = insur;
	}

	/**
	 * getter for id
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * setter for id
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * getter for birth date
	 * @return
	 */
	public String getBirthDate()
	{
		return birthDate;
	}

	/**
	 * setter for birth date
	 * @param birthDate
	 */
	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

	/**
	 * getter for insurance type
	 * @return
	 */
	public InsuranceType getInsur()
	{
		return insur;
	}

	/**
	 * setter for insurance type
	 * @param insur
	 */
	public void setInsur(InsuranceType insur)
	{
		this.insur = insur;
	}

	/**
	 * Determines the CoPay percentage for the user
	 * @param insurance
	 * @return
	 */
	@Override
	public double determineCoPay()
	{
		InsuranceType temp = getInsur();
		if(temp == InsuranceType.HEALTH_ALLIANCE)
		{
			return .05;
		}//end if
		
		else if(temp == InsuranceType.BLUE_CROSS_BLUE_SHIELD)
		{
			return .15;
		}//end else if
		
		else if(temp == InsuranceType.CIGNA)
		{
			return .1;
		}//end else if
		
		else
		{
			return 0;
		}//end else
	}

	@Override
	public String toString()
	{
		String patReturn = "Patient: " + getFirstName() + " " + getMiddleInitial() + " " + getLastName() + "/n" 
				+ "Id: " + getId() + "/nBirthdate: " + getBirthDate().substring(0, 2) + "/" 
				+ getBirthDate().substring(2, 4) + "/" + getBirthDate().substring(4, 8) + "/nInsurance: "
				+ getInsur();
		return patReturn;
	}
}
