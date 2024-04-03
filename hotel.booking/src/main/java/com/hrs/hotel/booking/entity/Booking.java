package com.hrs.hotel.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Booking class is an entity class to store booking details.
 */

@Table
@Entity
public class Booking {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	
	String startDate;
	String endDate;
	
	@ManyToOne
	@JoinColumn(name="room_id")
	Room room;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	BookingStatus status;
	
	public enum BookingStatus{
		CANCELLED,
		BOOKED
	}
	
	public Booking(Long id,String startDate, String endDate, Room room, Customer customer,BookingStatus status) {
		super();
		this.id=id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.customer = customer;
		this.status=status;
	}
	
	public Booking(String startDate, String endDate, Room room, Customer customer,BookingStatus status) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.customer = customer;
		this.status=status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	
	
	
	
}
