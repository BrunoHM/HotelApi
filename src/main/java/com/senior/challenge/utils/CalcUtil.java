package com.senior.challenge.utils;

public class CalcUtil {

	private DateUtil dateUtil = new DateUtil();
	private double totalBillingValue;
	
	private long daysAtHotel[];
	
	public double calcTotalBillingValue(String strDatetime1, String strDatetime2, boolean addGarage) {
		daysAtHotel = dateUtil.calcDiffDateTime(strDatetime1, strDatetime2, addGarage);
	
		totalBillingValue = (daysAtHotel[0]*120) + (daysAtHotel[1]*150);
		
		if(addGarage) {
			totalBillingValue += (daysAtHotel[0]*15) + (daysAtHotel[1]*20);	
		}
		
		return totalBillingValue;
	}

	public double getTotalBillingValue() {
		return totalBillingValue;
	}
	
}
