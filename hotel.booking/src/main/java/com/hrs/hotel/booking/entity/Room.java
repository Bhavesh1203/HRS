package com.hrs.hotel.booking.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Room class is an entity class to store room details.
 */

@Table
@Entity
public class Room {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	
	String type;
	Long price;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	Hotel hotel;
	
	@OneToMany(mappedBy="room")
	Set<Booking> bookings;

	public Room(Long id, String type, Long price, Hotel hotel) {
		super();
		this.id=id;
		this.type = type;
		this.price = price;
		this.hotel = hotel;
	}
	
	public Room(String type, Long price, Hotel hotel) {
		super();
		this.type = type;
		this.price = price;
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	} 
	
	
	
}