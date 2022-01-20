package com.crm.comcast.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author kajal
 *
 */
public class JavaUtility {
	/**
	 * This method will return random number
	 * @return
	 */
	public int getrandomNumber() {
		Random ran=new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;
	}

public String systemDateandTime() {
	Date date = new Date();
	String dateAndTime = date.toString();
	return dateAndTime;
}
}