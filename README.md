This is a sample Hotel Booking application created using springboot.

This application supports teh following api's:
1]api/hrs/booking/addBooking -> add a new booking for a customer.
2]api/hrs/booking/viewBookings -> view bookings for a customer.
3]api/hrs/booking/cancelBooking -> cancel a booking of a customer.

Following are the 4 entities that have been created in this project-
1]Hotel
2]Room
3]Booking
4]Customer
Relationship in the above tables:
Hotel->Room is a one to many mapping where a hotel can contain multiple rooms.
Room->Booking is a one to many mapping where a room can contain multiple bookings.
Customer->Booking is a one to many mapping where a customer can contain multiple bookings.

