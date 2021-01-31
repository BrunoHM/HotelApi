package com.senior.challenge.Hotel.services.CheckInOut;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.challenge.Hotel.dtos.CheckInOutDto;
import com.senior.challenge.Hotel.entities.CheckInOut;
import com.senior.challenge.Hotel.entities.Person;
import com.senior.challenge.Hotel.repositories.CheckInOutRepository;

@Service
public class CheckInOutServiceImpl implements CheckInOutService {

	@Autowired
	private CheckInOutRepository checkInOutRepository;

	@Override
	public boolean saveNewCheckInOut(CheckInOutDto checkInOutDto) {
		CheckInOut checkInOut = new CheckInOut(checkInOutDto.getIdCheckInOut(),
				OffsetDateTime.parse(checkInOutDto.getEntryDate()),
				OffsetDateTime.parse(checkInOutDto.getDepartureDate()),
				checkInOutDto.isAdditionalGarage());

		System.out.println(checkInOutRepository.save(checkInOut));
		return true;
	}

}
