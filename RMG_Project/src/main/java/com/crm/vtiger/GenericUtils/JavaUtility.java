package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/*
 * This class contains java specific generic libraries
 * @Soumya
 */

public class JavaUtility {
	
	/*
	 * Generarte Random Number
	 * @Soumya
	 */
	
	public static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	
	/*
	 * Generate Current System Date
	 */
	
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}

}
