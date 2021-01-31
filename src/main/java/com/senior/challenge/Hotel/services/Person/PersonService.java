package com.senior.challenge.Hotel.services.Person;

import com.senior.challenge.Hotel.dtos.PersonDto;
import com.senior.challenge.Hotel.entities.Person;

public interface PersonService {

	public boolean saveNewPerson(PersonDto personDto);
}
