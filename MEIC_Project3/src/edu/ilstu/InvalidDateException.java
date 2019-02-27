/*
 * File name: InvalidDateException.java
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
 * <insert class description here>
 *
 * @author Matthew Caparoon
 *
 */
@SuppressWarnings("serial")
public class InvalidDateException extends Exception
{
	public InvalidDateException() {
		super("Error:  Invalid Date");
	}

	public InvalidDateException(String str) {
		super("Date is not valid: " + str);
	}
}
