/*
 * File name: Appointment.java
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
 * Appointment setup class
 *
 * @author Matthew Caparoon
 *
 */
public class Appointment
{
	private Doctor doctor;
	private Patient patient;
	private String date;
	
	/**
	 * basic Appointment constructor
	 */
	public Appointment()
	{
		
	}
	
	/**
	 * Appointment constructor for the full constructor
	 * @param doctor
	 * @param patient
	 * @param date
	 */
	public Appointment(Doctor doctor, Patient patient, String date)
	{
		this.date = date;
		this.doctor = doctor;
		this.patient = patient;
	}

	/**
	 * getter for Doctor
	 * @return
	 */
	public Doctor getDoctor()
	{
		return doctor;
	}

	/**
	 * setter for Doctor
	 * @param doctor
	 */
	public void setDoctor(Doctor doctor)
	{
		this.doctor = doctor;
	}

	/**
	 * getter for Patient
	 * @return
	 */
	public Patient getPatient()
	{
		return patient;
	}

	/**
	 * setter for Patient
	 * @param patient
	 */
	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}

	/**
	 * getter for date
	 * @return
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * setter for date
	 * @param date
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	
	/**
	 * toString for the Appointment
	 */
	@Override
	public String toString()
	{
		String apptReturn = "Service Date: " + getDate() + "/n" + getDoctor().toString() + "/n/n" 
				+ getPatient().toString() + "/n/n" + "Ammount Billed: $" + getDoctor().getFee() + "/nCovered Ammount: $"
				+ (getDoctor().getFee() - (getDoctor().getFee() * getPatient().determineCoPay())) + "/nCoinsurance: $"
				+ (getDoctor().getFee() * getPatient().determineCoPay());
		return apptReturn;
	}
}
