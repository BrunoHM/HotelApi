package com.senior.challenge.Hotel.services.Person;


import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
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
	@Transactional
	public List<Object> findAllPersonOutHotel() {
		return personRepository.findAllPersonOutHotel();
	}

	@Override
	@Transactional
	public List<Object> findAllPersonAtHotel() {
		return personRepository.findAllPersonAtHotel();
	}
	
	@Override
	@Transactional
	public List<Person> findAllPersonByNameDocTel(PersonDto personDto) {
		String strToFind = "";
		
		if(personDto.getName() != null && !personDto.getName().isEmpty()) {
			strToFind = personDto.getName();
			
		}else if(personDto.getLastName() != null && !personDto.getLastName().isEmpty()) {
			strToFind = personDto.getLastName();
			
		}else if(personDto.getCpf() != null && !personDto.getCpf().isEmpty()) {
			strToFind = personDto.getCpf();
			
		} else if(personDto.getTelephoneNumber() != null && !personDto.getTelephoneNumber().isEmpty()) {
			strToFind = personDto.getTelephoneNumber();
		}
		return personRepository.findAllPersonByNameDocTel(strToFind);
	}
	
}
