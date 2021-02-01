package com.senior.challenge.utils;

import java.time.Duration;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class DateUtil {

	
	public OffsetDateTime formatDate(String strDate) {
		if(strDate != null && !strDate.trim().isEmpty()) {
			return OffsetDateTime.parse(strDate);
		}else {
			return null;
		}
	}
	
	public long[] calcDiffDateTime(String strDatetime1, String strDatetime2, boolean addGarage) {
		try {
			if(strDatetime1 != null && !strDatetime1.trim().isEmpty() &&
			   strDatetime2 != null && !strDatetime2.trim().isEmpty()) {
				
				ZonedDateTime entryDate = ZonedDateTime.parse(strDatetime1);
				ZonedDateTime departureDate = ZonedDateTime.parse(strDatetime2);
				Duration duration = Duration.between(entryDate, departureDate);
				
				long daysAtHotel = duration.toDays();
				
				if(strDatetime2.contains("+")) {
					strDatetime2 = strDatetime2.substring(strDatetime2.indexOf("T")+1, strDatetime2.indexOf("+"));	
				}else {
					strDatetime2 = strDatetime2.substring(strDatetime2.indexOf("T")+1, strDatetime2.indexOf("T")+9);
				}
				
				if(LocalTime.parse(strDatetime2).isAfter(LocalTime.parse("16:30:00"))) {
					daysAtHotel++;
				}
				
				long daysOfWeek = 0;
				long daysOfWeekend = 0;
				
				for(int index=0; index <= daysAtHotel-1; index++) {

					if(String.valueOf(entryDate.getDayOfWeek()).equals("SATURDAY") 
					|| String.valueOf(entryDate.getDayOfWeek()).equals("SUNDAY")) {
						daysOfWeekend++;
					}else {
						daysOfWeek++;
					}
					entryDate = entryDate.plusDays(1);
				}
				long calcValues[] = new long[2];
				calcValues[0] = daysOfWeek;
				calcValues[1] = daysOfWeekend;
				
				return calcValues;
			}
		}catch(DateTimeParseException e) {
			System.err.println("A error has ocurred at date parsing method.");
			return null;
		}
		return null;
	}
}
