package com.senior.challenge.Hotel.services.CheckInOut;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.challenge.Hotel.dtos.CheckInOutDto;
import com.senior.challenge.Hotel.entities.CheckInOut;
import com.senior.challenge.Hotel.repositories.CheckInOutRepository;
import com.senior.challenge.Hotel.repositories.PersonRepository;
import com.senior.challenge.utils.CalcUtil;
import com.senior.challenge.utils.DateUtil;

@Service
public class CheckInOutServiceImpl implements CheckInOutService {

	DateUtil dateUtil = new DateUtil();
	CalcUtil calcUtil = new CalcUtil();
	
	@Autowired
	private CheckInOutRepository checkInOutRepository;
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	@Transactional
	public boolean saveNewCheckInOut(CheckInOutDto checkInOutDto) {
		CheckInOut checkInOut = new CheckInOut(checkInOutDto.getIdCheckInOut(),
				dateUtil.formatDate(checkInOutDto.getEntryDate()),
				dateUtil.formatDate(checkInOutDto.getDepartureDate()),
				checkInOutDto.isAdditionalGarage(),
				checkInOutDto.getBillingValue(),
				personRepository.findById(checkInOutDto.getPerson_idPerson()).get());
				
		checkInOutRepository.save(checkInOut);
		return true;
	}

	@Override
	@Transactional
	public boolean saveNewCheckOut(CheckInOutDto checkOutDto) {
		boolean updateSucessful = false;
		
		if(checkOutDto.getEntryDate() != null && !checkOutDto.getEntryDate().trim().isEmpty()) {
			
			calcUtil.calcTotalBillingValue(checkOutDto.getEntryDate(), checkOutDto.getDepartureDate(), checkOutDto.isAdditionalGarage());
			checkOutDto.setBillingValue(calcUtil.getTotalBillingValue());
			
			if(checkInOutRepository.updateCheckInOut(checkOutDto.getIdCheckInOut(),
												     dateUtil.formatDate(checkOutDto.getDepartureDate()),
												     checkOutDto.getBillingValue()) == 1) {
				updateSucessful = true;
			}
		}
		return updateSucessful;
	}

}
