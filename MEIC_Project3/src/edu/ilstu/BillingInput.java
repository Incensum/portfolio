/*
 * File name: BillingInput.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Takes all input from the file, then directs it to the Billing class
 *
 * @author Matthew Caparoon
 *
 */
public class BillingInput
{
	Validation valid = new Validation();
	
	/**
	 * Reads the input file, and sets up the Array list
	 * @param filename
	 * @return
	 * @throws InvalidDateException 
	 */
	@SuppressWarnings("resource")
	public ArrayList<Appointment> readInput(String filename) throws InvalidDateException
	{
		Scanner input = null;
		int length = 6;
		
		ArrayList<Appointment> appoint = new ArrayList<Appointment>(length);
		
		//takes in the values, and puts them into the arrayList
		try
		{
			input = new Scanner(new File(filename));
			
			while(input.hasNext())
			{
				String rawDate = input.next(); //date setup
				Validation.isRealDate(rawDate);
				String date = rawDate.substring(0, 2) + "/" + rawDate.substring(2, 4) + "/" + rawDate.substring(4,8);
				
				String docFirstName = input.next(); //doctor setup
				String docMidInitial = input.next();
				String docLastName = input.next();
				Specialty spec = Specialty.valueOf(input.next());
				double fee = Double.valueOf(input.next());
				Doctor doc = new Doctor(docFirstName, docMidInitial, docLastName, spec, fee);
				
				String patFirstName = input.next(); //patient setup
				String patMidInitial = input.next();
				String patLastName = input.next();
				String id = input.next();
				String rawBirthDate = input.next(); //birthdate setup
				Validation.isRealDate(rawBirthDate);
				String birthdate = rawBirthDate.substring(0, 2) + "/" + rawBirthDate.substring(2, 4) + "/"
						+ rawBirthDate.substring(4, 8);
				InsuranceType insur = InsuranceType.valueOf(input.next());
				Patient pat = new Patient(patFirstName, patMidInitial, patLastName, id, birthdate, insur);
				
				Appointment appt = new Appointment(doc, pat, date);
				
				appoint.add(appt);
				
			}//end while
		}//end try
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File Cannot Be Found");
			fnfe.printStackTrace();
		}//end catch
		catch (InvalidDateException ide)
		{
			throw new InvalidDateException(" ");
		}//end catch
		
		return appoint;
	}
}
