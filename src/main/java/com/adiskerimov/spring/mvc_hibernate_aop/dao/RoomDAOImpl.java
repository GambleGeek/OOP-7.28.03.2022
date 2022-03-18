package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Order;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Room> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();

        Query<Room> query = session.createQuery("from Room", Room.class);
        List<Room> allRooms = query.getResultList();

        return allRooms;
    }

    @Override
    public void saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }
}
