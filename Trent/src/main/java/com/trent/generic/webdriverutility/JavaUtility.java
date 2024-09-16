package com.trent.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandonNumber() {
		Random random= new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}

	public String getSystemDateYYYYMMDD() {
		Date date= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String actualdate = sim.format(date);
		return actualdate;
	}
	public String getRequiredDateyyyymmdd(int days) {
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requireddate = sim.format(cal.getTime());
		return requireddate;

		
	}
}
