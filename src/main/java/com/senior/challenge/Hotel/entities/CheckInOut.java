package com.senior.challenge.Hotel.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Table(name = "\"checkinout\"")
public class CheckInOut {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="\"entryDate\"")
	private OffsetDateTime entryDate;
	
	@Column(name="\"departureDate\"")
	private OffsetDateTime departureDate;
	
	@Column(name="\"additionalGarage\"")
	private boolean additionalGarage;
	
	@Column(name="\"billingValue\"")
	private double billingValue;
	
	@ManyToOne
	@JoinColumn(name = "\"person_idPerson\"", referencedColumnName = "\"id\"")
	private Person person_idPerson;
	
}
