package com.hrs.hotel.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrs.hotel.booking.entity.Room;

/**
 * This acts as a data layer, it will fetch the external service information from database and bind with HotelBookinSerive class. 
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
