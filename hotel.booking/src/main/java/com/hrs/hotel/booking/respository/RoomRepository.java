package com.hrs.hotel.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrs.hotel.booking.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
