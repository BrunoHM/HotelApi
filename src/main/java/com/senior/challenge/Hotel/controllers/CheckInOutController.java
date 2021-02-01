package com.senior.challenge.Hotel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senior.challenge.Hotel.dtos.CheckInOutDto;
import com.senior.challenge.Hotel.services.CheckInOut.CheckInOutService;

@RestController
@CrossOrigin(origins = "*")
public class CheckInOutController {

	@Autowired
	CheckInOutService checkInOutService;
	
	@PostMapping(path = "/saveCheckInOut")
	public boolean insertNewCheckInOut(@RequestBody CheckInOutDto checkInOutDto){		
		return checkInOutService.saveNewCheckInOut(checkInOutDto);
	}
	
	@PostMapping(path = "/saveCheckOut")
	public boolean insertNewCheckOut(@RequestBody CheckInOutDto checkOutDto){		
		return checkInOutService.saveNewCheckOut(checkOutDto);
	}
	
}
