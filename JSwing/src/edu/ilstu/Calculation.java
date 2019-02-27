package edu.ilstu;

/**
 * @author Matthew Caparoon
 *
 */
public class Calculation {
	
	//distance
	public double metersToKm(double meters){
		return meters / 1000;
	}
	public double cmToMeters(double cm){
		return cm / 100;
	}
	public double kmToMiles(double km){
		return km * 0.621371;
	}
	public double feetToInches(double feet){
		return feet * 12;
	}
	public double inchesToCm(double inch){
		return inch * 2.54;
	}
	public double milesToFeet(double mi){
		return mi * 5280;
	}

	//mass
	public double lbToITon(double lb){
		return lb * 0.000446429;
	}
	public double ozToLb(double oz){
		return oz / 16;
	}
	public double kgToOz(double kg){
		return kg * 35.274;
	}
	public double gramToKg(double gram){
		return gram / 1000;
	}
	public double iTonToMTon(double iton){
		return iton * 1.01605;
	}
	public double mTonToGram(double mton){
		return mton * 1000000;
	}
}
