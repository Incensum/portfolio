/*
 * File name: InvalidPatientIdException.java
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
 * Exception for any invalidation of the Patient Id value
 *
 * @author Matthew Caparoon
 *
 */
@SuppressWarnings("serial")
public class InvalidPatientIdException extends Exception
{
	public InvalidPatientIdException() {
		super("Error:  Invalid Patient ID");
	}

	public InvalidPatientIdException(String str) {
		super("Id not all numeric: " + str);
	}
}
