package edu.mum.cs.cs425.bookingFlightApplication.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import edu.mum.cs.cs425.bookingFlightApplication.model.Airport;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends  JpaRepository<Airport,Integer>{
 
	List<Airport> findAllByOrderByAirportNameAsc();

}
