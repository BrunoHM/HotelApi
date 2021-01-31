package com.senior.challenge.Hotel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senior.challenge.Hotel.dtos.PersonDto;
import com.senior.challenge.Hotel.services.Person.PersonService;


@RestController
@CrossOrigin(origins = "*")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@PostMapping(path = "/savePerson")
	public boolean insertNewPerson(@RequestBody PersonDto personDto){		
		return personService.saveNewPerson(personDto);
	}
	
}
