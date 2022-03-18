package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tourist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TouristDAOImpl implements TouristDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tourist> getAllTourists() {
        Session session = sessionFactory.getCurrentSession();

        Query<Tourist> query = session.createQuery("from Tourist", Tourist.class);
        List<Tourist> allTourists = query.getResultList();

        return allTourists;
    }

    @Override
    public void saveTourist(Tourist tourist) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourist);
    }
}
