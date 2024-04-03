package com.hrs.hotel.booking.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Hotel class is an entity class to store hotel details.
 */

@Table
@Entity
public class Hotel {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	String name;
	String city;
	String state;
	String country;
	Long pincode;
	String address;
	
	@OneToMany(mappedBy = "hotel")
	private Set<Room> rooms;

	public Hotel(String name, String city, String state, String country, Long pincode, String address) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.address = address;
	}
	
	public Hotel(Long id,String name, String city, String state, String country, Long pincode, String address) {
		super();
		this.id=id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	
}
