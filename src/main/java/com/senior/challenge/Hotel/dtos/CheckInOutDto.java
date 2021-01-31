package com.senior.challenge.Hotel.dtos;

import java.sql.Timestamp;

import com.senior.challenge.Hotel.entities.Person;

public class CheckInOutDto {
	
	private Long idCheckInOut;
	private String entryDate;
	private String departureDate;
	private boolean additionalGarage;
	
	private Person FKPerson_idPerson;
	

	public Long getIdCheckInOut() {
		return idCheckInOut;
	}

	public void setIdCheckInOut(Long idCheckInOut) {
		this.idCheckInOut = idCheckInOut;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public boolean isAdditionalGarage() {
		return additionalGarage;
	}

	public void setAdditionalGarage(boolean additionalGarage) {
		this.additionalGarage = additionalGarage;
	}

	public Person getFKPerson_idPerson() {
		return FKPerson_idPerson;
	}

	public void setFKPerson_idPerson(Person fKPerson_idPerson) {
		FKPerson_idPerson = fKPerson_idPerson;
	}
}
