package com.senior.challenge.Hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senior.challenge.Hotel.dtos.PersonDto;
import com.senior.challenge.Hotel.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	//Busca pessoas que não estão hospedadas no hotel atualmente
	@Query(value = "select b.*, sum(a.\\\"billingValue\\\") as \\\"totalBillingValue\\\", (array_agg(a.\\\"billingValue\\\" ORDER BY a.\\\"id\\\" DESC))[1] as \\\"lastBillingValue\\\" from dtbhotel.checkinout as \"a\" INNER JOIN dtbhotel.person as \"b\" ON a.\"person_idPerson\" = b.\"id\" WHERE a.\"departureDate\" is not null AND b.\"id\" not in (select distinct \"person_idPerson\" from dtbhotel.checkinout as \"a\" where a.\"departureDate\" is null) GROUP BY b.\"id\";", nativeQuery = true)
	public List<Object> findAllPersonOutHotel();

	//Busca pessoas que estão hospedadas no hotel atualmente
	@Query(value = "select b.*, sum(a.\"billingValue\") as \"totalBillingValue\", (array_agg(a.\"billingValue\" ORDER BY a.\"id\" DESC))[1] as \"lastBillingValue\"  from dtbhotel.checkinout as \"a\" INNER JOIN dtbhotel.person as \"b\" ON a.\"person_idPerson\" = b.\"id\" WHERE b.\"id\" in (select distinct \"person_idPerson\" from dtbhotel.checkinout as \"a\" where a.\"departureDate\" is null) GROUP BY b.\"id\";", nativeQuery = true)
	public List<Object> findAllPersonAtHotel();
	
	//Busca as pessoas por filtro
	@Query(value = "SELECT * FROM dtbhotel.person WHERE \"firstName\" = ?1 or \"lastName\" LIKE ?1 or \"cpf\" LIKE ?1  or \"telephoneNumber\" LIKE ?1 GROUP BY \"id\" ;", nativeQuery = true)
	public List<Person> findAllPersonByNameDocTel(String strParam);
	
}