/*
 * File name: Billing.java
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

import java.util.ArrayList;

/**
 * The driver for project 3
 *
 * @author Matthew Caparoon
 *
 */
public class Billing
{
	/**
	 * Main method for billing
	 * @param args
	 * @throws InvalidDateException 
	 */
	public static void main(String[] args) throws InvalidDateException
	{
		final String FILENAME = "ClinicBilling.txt";
		BillingInput input = new BillingInput();
		BillingOutput output = new BillingOutput();

		ArrayList<Appointment> appt = input.readInput(FILENAME);
		
		for(int i = 0; i < appt.size(); i++)
		{
			output.printBorder();
			appt.toString();
			output.printBorder();
		}//end for
	}

}
