package com.hrs.hotel.booking.manager;

import org.springframework.http.ResponseEntity;

import com.hrs.hotel.booking.rest.request.AddBookingRequest;
import com.hrs.hotel.booking.rest.request.CancelBookingRequest;
import com.hrs.hotel.booking.rest.request.ViewBookingRequest;

/**
 * HotelBookingManager interface is used to define the methods to be implemented for a service to act as HotelService.
 */

public interface HotelBookingManager {

	public ResponseEntity<Object> addBooking(AddBookingRequest addBookingRequest);
	
	public ResponseEntity<Object> viewBooking(ViewBookingRequest viewBookingRequest);
	
	public ResponseEntity<Object> cancelBooking(CancelBookingRequest cancelBookingRequest);
}
