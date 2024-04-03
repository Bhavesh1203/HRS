package com.hrs.hotel.booking.rest.response;

import java.util.Objects;

public class CancelBookingResponse {

	String hotelName;
	String roomType;
	Long price;
	String startDate;
	String endDate;
	
	public CancelBookingResponse(String hotelName, String roomType, Long price, String startDate, String endDate) {
		super();
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
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

	@Override
	public int hashCode() {
		return Objects.hash(endDate, hotelName, price, roomType, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancelBookingResponse other = (CancelBookingResponse) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(hotelName, other.hotelName)
				&& Objects.equals(price, other.price) && Objects.equals(roomType, other.roomType)
				&& Objects.equals(startDate, other.startDate);
	}
	
	
	
}
