package com.hrs.hotel.booking;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrs.hotel.booking.entity.Booking;
import com.hrs.hotel.booking.entity.Booking.BookingStatus;
import com.hrs.hotel.booking.entity.Customer;
import com.hrs.hotel.booking.entity.Hotel;
import com.hrs.hotel.booking.entity.Room;
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
import com.hrs.hotel.booking.service.HotelBookingService;

@SpringBootTest
class HotelBookingApplicationTests {
	
	@MockBean
	HotelBookingService hotelBookingService;
	
	@Mock
	BookingRepository bookingRepository;
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	RoomRepository roomRepository;
	
	@Mock
	HotelRepository hotelRepository;
	
	@Mock
	MockHttpServletRequest req;
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.openMocks(this);
		req=new MockHttpServletRequest();
	}
	
	@AfterMethod
	public void afterMethod() {
	}

//	Booking 101
//	Customer 201
//	Hotel 301
//	Room 401
	
	@Test
	public void addBookingTest() {
		AddBookingRequest bookingRequest=new AddBookingRequest(201L, 401L, "03/04/2024", "05/04/2024");
		
		AddBookingResponse expectedAddBookingResponse=new AddBookingResponse("Taj", "Deluxe", 2500L, "03/04/2024", "05/04/2024");
		
		Customer customer=new Customer(201L,"johnjohnson@gmail.com", "John", "JohnJohnson@109", "John", "Johnson", "Mumbai", "Maharashtra", "India");
		Optional<Customer> customerOptional=Optional.of(customer);
		Hotel hotel=new Hotel(301L, "Taj", "Mumbai", "Maharashtra", "India", 410012L, "Andheri");
		Room room=new Room(401L,"Deluxe",2500L,hotel);
		Optional<Room> roomOptional=Optional.of(room);
		
		doReturn(customerOptional).when(customerRepository).findById(Mockito.anyLong());
		doReturn(roomOptional).when(roomRepository).findById(Mockito.anyLong());
		
		ResponseEntity<Object> response= hotelBookingService.addBooking(bookingRequest);
		AddBookingResponse actualAddBookingResponse=(AddBookingResponse)response.getBody();
		
		assertTrue(expectedAddBookingResponse.equals(actualAddBookingResponse));
	}
	
	@Test
	public void viewBookingsTest() {
		ViewBookingRequest viewBookingRequest=new ViewBookingRequest(201L);
		ViewBookingResponse expectedBookingResponse=new ViewBookingResponse("Taj", "Deluxe", 2500L, "03/04/2024", "05/04/2024", "Andheri", BookingStatus.BOOKED.name());
		List<ViewBookingResponse> expectedBookingResponseList=new ArrayList<>();
		expectedBookingResponseList.add(expectedBookingResponse);
		
		Customer customer=new Customer(201L,"johnjohnson@gmail.com", "John", "JohnJohnson@109", "John", "Johnson", "Mumbai", "Maharashtra", "India");
		Hotel hotel=new Hotel(301L, "Taj", "Mumbai", "Maharashtra", "India", 410012L, "Andheri");
		Room room=new Room(401L,"Deluxe",2500L,hotel);
		Booking booking=new Booking(101L, "03/04/2024", "05/04/2024",room,customer,BookingStatus.BOOKED);
		Set<Booking> bookingSet=new HashSet<>();
		bookingSet.add(booking);
		customer.setBookings(bookingSet);
		Optional<Customer> customerOptional=Optional.of(customer);
		
		doReturn(customerOptional).when(customerRepository).findById(Mockito.anyLong());
		
		ResponseEntity<Object> response=hotelBookingService.viewBooking(viewBookingRequest);
		List<ViewBookingResponse> actualBookingResponseList=(List<ViewBookingResponse>)response.getBody();
		
		assertTrue(expectedBookingResponseList.equals(actualBookingResponseList));
	}
	
	@Test
	public void cancelBookingTest() {
		CancelBookingRequest cancelBookingRequest=new CancelBookingRequest(101L);
		CancelBookingResponse expectedCancelBookingResponse=new CancelBookingResponse("Taj", "Deluxe", 2500L,"03/04/2024", "05/04/2024");
		
		Customer customer=new Customer(201L,"johnjohnson@gmail.com", "John", "JohnJohnson@109", "John", "Johnson", "Mumbai", "Maharashtra", "India");
		Hotel hotel=new Hotel(301L, "Taj", "Mumbai", "Maharashtra", "India", 410012L, "Andheri");
		Room room=new Room(401L,"Deluxe",2500L,hotel);
		Booking booking=new Booking(101L, "03/04/2024", "05/04/2024",room,customer,BookingStatus.BOOKED);
		Optional<Booking> bookingOptional=Optional.of(booking);
		
		doReturn(bookingOptional).when(bookingRepository).findById(Mockito.anyLong());
		
		ResponseEntity<Object> response=hotelBookingService.cancelBooking(cancelBookingRequest);
		CancelBookingResponse actualCancelBookingResponse=(CancelBookingResponse)response.getBody();
		
		assertTrue(actualCancelBookingResponse.equals(expectedCancelBookingResponse));
		
	}
	
	

}
