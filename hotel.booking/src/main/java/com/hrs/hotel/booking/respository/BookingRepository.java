package com.hrs.hotel.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrs.hotel.booking.entity.Booking;

/**
 * 
 */

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
