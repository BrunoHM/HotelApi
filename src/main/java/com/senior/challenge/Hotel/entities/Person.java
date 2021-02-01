package com.senior.challenge.Hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Table(name = "\"person\"")
public class Person{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="\"firstName\"")
	private String firstName;
	
	@Column(name="\"lastName\"")
	private String lastName;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="ddd")
	private String ddd;
	
	@Column(name="\"telephoneNumber\"")
	private String telephoneNumber;
	
}
