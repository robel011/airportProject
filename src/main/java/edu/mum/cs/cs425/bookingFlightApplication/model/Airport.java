package edu.mum.cs.cs425.bookingFlightApplication.model;

import javax.persistence.*;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Table;

@Entity
@Table(name="Airport")
public class Airport {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="airportId")
	private int airportId;
	
	@Column(name="airportCode")
	private int airportCode;
	
	@Column(name="airportName")
	private String airportName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	public Airport() {
		
	}

	public Airport( int airportId,int airportCode, String airportName, String city, String country) {
		
		this.airportId = airportId;
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.city = city;
		this.country = country;
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public int getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(int airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportCode=" + airportCode + ", airportName=" + airportName
				+ ", city=" + city + ", country=" + country + "]";
	}

}
