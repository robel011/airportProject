package edu.mum.cs.cs425.bookingFlightApplication.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.bookingFlightApplication.model.Airport;
import edu.mum.cs.cs425.bookingFlightApplication.repository.AirportRepository;
import edu.mum.cs.cs425.bookingFlightApplication.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{
    
	@Autowired
	private AirportRepository airportRepository;
	
	
	@Override
	public Airport save(Airport airport) {
		
		return airportRepository.save(airport);
	}

	@Override
	public Airport getAirportById(int id) {
		
		return airportRepository.getOne(id);
	}

//	@Override
//	public Iterable<Airport> getAirports() {
//		
//		return airportRepository.findAll();
//	}

	@Override
	public void delete(int id) {
		
		airportRepository.deleteById(id);
		
	}
	
	public long count() {
		return airportRepository.count();
	}
	
	@Override
	public List<Airport> getAll(){
		return airportRepository.findAll();
	}
	
	

}
