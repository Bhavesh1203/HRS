package com.hrs.hotel.booking.rest.request;

public class AddBookingRequest {
	Long customerId;
	Long roomId;
	String startDate;
	String endDate;
	
	public AddBookingRequest(Long customerId, Long roomId,String startDate,String endDate) {
		super();
		this.customerId = customerId;
		this.roomId = roomId;
		this.startDate=startDate;
		this.endDate=endDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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
	
	
	
}
