package com.hrs.hotel.booking.rest.response;

import java.util.Objects;

/**
 * ViewBookingRequest - This class represents a new booking request.
 * Json passed in as a request body to /viewBookings end point will be converted to this Request class.
 */
public class ViewBookingResponse {
	String hotelName;
	String roomType;
	Long price;
	String startDate;
	String endDate;
	String address;
	String status;
	
	public ViewBookingResponse(String hotelName, String roomType, Long price, String startDate, String endDate,
			String address,String status) {
		super();
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.status=status;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, endDate, hotelName, price, roomType, startDate, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewBookingResponse other = (ViewBookingResponse) obj;
		return Objects.equals(address, other.address) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(hotelName, other.hotelName) && Objects.equals(price, other.price)
				&& Objects.equals(roomType, other.roomType) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(status, other.status);
	}
	
	
	
	
	
}
