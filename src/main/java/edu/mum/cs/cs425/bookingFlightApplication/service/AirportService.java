package edu.mum.cs.cs425.bookingFlightApplication.service;

import java.util.List;

import edu.mum.cs.cs425.bookingFlightApplication.model.Airport;

public interface AirportService {
	
	//public Iterable<Airport> getAirports();
	
	public Airport save(Airport airport);
	
	public Airport getAirportById(int id);
	
	public void delete(int id);
	
	public List<Airport> getAll();
		

}
