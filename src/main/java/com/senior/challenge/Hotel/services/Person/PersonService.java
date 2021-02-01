package com.senior.challenge.Hotel.services.Person;

import java.util.List;

import com.senior.challenge.Hotel.dtos.PersonDto;
import com.senior.challenge.Hotel.entities.Person;

public interface PersonService {

	public boolean saveNewPerson(PersonDto personDto);
	
	public List<Object> findAllPersonOutHotel();
	
	public List<Object> findAllPersonAtHotel();
	
	public List<Person> findAllPersonByNameDocTel(PersonDto personDto);
	
	
}
