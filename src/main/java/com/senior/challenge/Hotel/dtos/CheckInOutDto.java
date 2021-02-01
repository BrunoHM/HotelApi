package com.senior.challenge.Hotel.dtos;

public class CheckInOutDto {
	
	private Long idCheckInOut;
	private String entryDate;
	private String departureDate;
	private boolean additionalGarage;
	private double billingValue;
	
	private Long person_idPerson;
	
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

	public Long getPerson_idPerson() {
		return person_idPerson;
	}

	public void setPerson_idPerson(Long person_idPerson) {
		this.person_idPerson = person_idPerson;
	}

	public double getBillingValue() {
		return billingValue;
	}

	public void setBillingValue(double billingValue) {
		this.billingValue = billingValue;
	}
	
}
