package com.senior.challenge.Hotel.repositories;

import java.time.OffsetDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senior.challenge.Hotel.entities.CheckInOut;

@Repository
public interface CheckInOutRepository extends JpaRepository<CheckInOut, Long>{
	
	//Altera o checkInOut do hóspede
	@Modifying
	@Query(value = "UPDATE dtbhotel.checkinout SET \"departureDate\" = ?2, \"billingValue\" = ?3 WHERE \"id\" = ?1 ;", nativeQuery = true)
	public int updateCheckInOut(Long idCheckInOut, OffsetDateTime departureDate, double finalBillingValue);
	
}
