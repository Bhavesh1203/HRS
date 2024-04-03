package com.hrs.hotel.booking.rest.request;

public class CancelBookingRequest {
	Long bookingId;

	public CancelBookingRequest(Long bookingId) {
		super();
		this.bookingId = bookingId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
}
