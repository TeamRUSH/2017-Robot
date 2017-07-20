package org.usfirst.frc27.robot.util;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Created by cyocom on 2/5/17.
 */
public class NumericUtil {

	public static Integer tryToGetIntegerValueOf(String value, String name) {
		try{
			return Integer.valueOf(value);
		} catch(NumberFormatException e){
			DriverStation.reportError(String.format("Parameter %s - Value %s could not be parsed to Integer!", name, value), false);
			return 0;
		}
	}

	public static Double tryToGetDoubleValueOf(String value, String name) {
		try{
			return Double.valueOf(value);
		} catch(NumberFormatException e){
			DriverStation.reportError(String.format("Parameter %s - Value %s could not be parsed to Double!", name, value), false);
			return 0d;
		}
	}

}
