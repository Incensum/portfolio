/*
 * File name: Validation.java
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
 * Validates if Strings are Numeric
 *
 * @author Matthew Caparoon
 *
 */
public class Validation
{
	/**
	 * Tests to see if the value of the patient ID is all numerical
	 * @param str
	 * @throws InvalidPatientIdException
	 */
	public static void isNumeric(String str)throws InvalidPatientIdException
	{
		boolean valid = true;
		String regex = "[0-9/.]*";
		
		valid = str.matches(regex);
		
		if(!valid)
		{
			throw new InvalidPatientIdException(str);
		}//end if
	}
	
	/**
	 * Tests to see if the value of the date is numerical, or real
	 * @param str
	 * @throws InvalidDateException
	 */
	public static void isRealDate(String str)throws InvalidDateException
	{
		boolean valid = true;
		boolean valid2 = true;
		String month = str.substring(0, 2);
		String day = str.substring(2, 4);
		
		String regex1 = "[0-12/.]*"; //month
		String regex2 = "[0-28/.]*"; //february
		String regex3 = "[0-30/.]*"; //sept, apr, jun, nov
		String regex4 = "[0-31/.]*"; //other
		
		valid = month.matches(regex1);
		if(!valid) //if the month isn't valid
		{
			throw new InvalidDateException(str);
		}//end if
		
		else //if the month is valid
		{
			if(month.equals("02"))
			{
				valid2 = day.matches(regex2);
				if(!valid2)
				{
					throw new InvalidDateException(str);
				}//end if
			}//end if
			
			if(month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11"))
			{
				valid2 = day.matches(regex3);
				if(!valid2)
				{
					throw new InvalidDateException(str);
				}//end if
			}//end if
			
			else
			{
				valid2 = day.matches(regex4);
				if(!valid2)
				{
					throw new InvalidDateException(str);
				}//end if
			}//end else
		}//end else
	}
}
