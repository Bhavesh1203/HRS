package com.hrs.hotel.booking.rest.request;

public class ViewBookingRequest {
	Long customerId;

	public ViewBookingRequest(Long customerId) {
		super();
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
