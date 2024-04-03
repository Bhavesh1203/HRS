package com.hrs.hotel.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.hotel.booking.manager.HotelBookingManager;
import com.hrs.hotel.booking.rest.request.AddBookingRequest;
import com.hrs.hotel.booking.rest.request.CancelBookingRequest;
import com.hrs.hotel.booking.rest.request.ViewBookingRequest;
import com.hrs.hotel.booking.utils.HotelBookingApplicationUtils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * HotelBookingController:- This class provides the endpoints for the HotelBookingService
 */

@RestController
@RequestMapping(value=HotelBookingApplicationUtils.ENDPOINT_BOOKING)
public class HotelBookingController {

	@Autowired
	HotelBookingManager hotelBookingManager;
	
	@PostMapping(value = HotelBookingApplicationUtils.ENDOINT_ADD_BOOKING)
	public ResponseEntity<Object> addBooking(HttpServletRequest request, @RequestBody AddBookingRequest addBookingRequest) {
		return hotelBookingManager.addBooking(addBookingRequest);
	}
	
	@PostMapping(value = HotelBookingApplicationUtils.ENDOINT_VIEW_BOOKINGS)
	public ResponseEntity<Object> viewBooking(HttpServletRequest request,@RequestBody ViewBookingRequest viewBookingRequest) {
		return hotelBookingManager.viewBooking(viewBookingRequest);
	}
	
	@PostMapping(value = HotelBookingApplicationUtils.ENDOINT_CANCEL_BOOKING)
	public ResponseEntity<Object> cancelBooking(HttpServletRequest request,@RequestBody CancelBookingRequest cancelBookingRequest) {
		return hotelBookingManager.cancelBooking(cancelBookingRequest);
	}
	
}
