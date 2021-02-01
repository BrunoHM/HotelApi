package com.senior.challenge.Hotel.services.Person;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.challenge.Hotel.dtos.PersonDto;
import com.senior.challenge.Hotel.entities.Person;
import com.senior.challenge.Hotel.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public boolean saveNewPerson(PersonDto personDto) {
		Person person = new Person(  personDto.getId(),
										 personDto.getName(),
									     personDto.getLastName(),
									     personDto.getCpf(),
									     personDto.getDdd(),
									     personDto.getTelephoneNumber());
		 
			System.out.println(personRepository.save(person));
			return true;
	}

	@Override
	public List<Object> findAllPersonOutHotel() {
		return personRepository.findAllPersonOutHotel();
	}

	@Override
	public List<Object> findAllPersonAtHotel() {
		return personRepository.findAllPersonAtHotel();
	}
	
}
