package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Room;

import java.util.List;

public interface RoomDAO {
    public List<Room> getAllRooms();

    public void saveRoom(Room room);
}
