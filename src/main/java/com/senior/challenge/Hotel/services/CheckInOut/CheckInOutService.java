package com.senior.challenge.Hotel.services.CheckInOut;


import com.senior.challenge.Hotel.dtos.CheckInOutDto;

public interface CheckInOutService {
	
	public boolean saveNewCheckInOut(CheckInOutDto checkInOutDto);
	
	public boolean saveNewCheckOut(CheckInOutDto checkOutDto);
	
}
