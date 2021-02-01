package com.senior.challenge.Hotel.dtos;

public class PersonDto {

	private Long id;
	private String name;
	private String lastName;
	private String cpf;
	private String ddd;
	private String telephoneNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long idPerson) {
		this.id = idPerson;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
}
