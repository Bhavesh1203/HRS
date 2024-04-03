package com.hrs.hotel.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hrs.hotel.booking.entity.Booking;
import com.hrs.hotel.booking.entity.Booking.BookingStatus;
import com.hrs.hotel.booking.entity.Customer;
import com.hrs.hotel.booking.entity.Hotel;
import com.hrs.hotel.booking.entity.Room;
import com.hrs.hotel.booking.manager.HotelBookingManager;
import com.hrs.hotel.booking.respository.BookingRepository;
import com.hrs.hotel.booking.respository.CustomerRepository;
import com.hrs.hotel.booking.respository.HotelRepository;
import com.hrs.hotel.booking.respository.RoomRepository;
import com.hrs.hotel.booking.rest.request.AddBookingRequest;
import com.hrs.hotel.booking.rest.request.CancelBookingRequest;
import com.hrs.hotel.booking.rest.request.ViewBookingRequest;
import com.hrs.hotel.booking.rest.response.AddBookingResponse;
import com.hrs.hotel.booking.rest.response.CancelBookingResponse;
import com.hrs.hotel.booking.rest.response.ViewBookingResponse;

/**
 * 
 */

@Service
public class HotelBookingService implements HotelBookingManager{

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	RoomRepository roomRepository;
	
	public ResponseEntity<Object> addBooking(AddBookingRequest addBookingRequest) {
		Long customerId=addBookingRequest.getCustomerId();
		Long roomId=addBookingRequest.getRoomId();
		String startDate=addBookingRequest.getStartDate();
		String endDate=addBookingRequest.getEndDate();
		
		Customer customer=customerRepository.findById(customerId).get();
		Room room=roomRepository.findById(roomId).get();
		
		Booking booking=new Booking(startDate, endDate, room, customer,BookingStatus.BOOKED);
		booking=bookingRepository.save(booking);
		
		Hotel hotel=room.getHotel();
		
		AddBookingResponse bookingResponse=new AddBookingResponse(hotel.getName(), room.getType(), room.getPrice(), startDate, endDate);
		
		return new ResponseEntity<Object>(bookingResponse, HttpStatus.CREATED);
	}
	public ResponseEntity<Object> viewBooking(ViewBookingRequest viewBookingRequest) {
		Long customerId=viewBookingRequest.getCustomerId();
		
		Customer customer=customerRepository.findById(customerId).get();
		Set<Booking> bookings=customer.getBookings();
		List<ViewBookingResponse> bookingResponseList=new ArrayList<>();
		for(Booking booking:bookings) {
			Room room=booking.getRoom();
			Hotel hotel=room.getHotel();
			ViewBookingResponse bookingResponse=new ViewBookingResponse(hotel.getName(),room.getType() , room.getPrice(), booking.getStartDate(), booking.getEndDate(),hotel.getAddress(),booking.getStatus().name());
			bookingResponseList.add(bookingResponse);
		}
		
		return new ResponseEntity<Object>(bookingResponseList, HttpStatus.OK);
	}
	public ResponseEntity<Object> cancelBooking(CancelBookingRequest cancelBookingRequest) {
		Long bookingId=cancelBookingRequest.getBookingId();
		
		Booking booking=bookingRepository.findById(bookingId).get();
		booking.setStatus(BookingStatus.CANCELLED);
		Room room=booking.getRoom();
		Hotel hotel=room.getHotel();
		
		bookingRepository.save(booking);
		
		CancelBookingResponse bookingResponse=new CancelBookingResponse(hotel.getName(), room.getType(), room.getPrice(), booking.getStartDate(), booking.getEndDate());
		
		return new ResponseEntity<Object>(bookingResponse, HttpStatus.OK);
		
	}
}
