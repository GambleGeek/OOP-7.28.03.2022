package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourFlightDAOImpl implements TourFlightDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TourFlight> getAllTourFlights() {
        Session session = sessionFactory.getCurrentSession();

        Query<TourFlight> query = session.createQuery("from TourFlight", TourFlight.class);
        List<TourFlight> allTourFlights = query.getResultList();

        return allTourFlights;
    }

    @Override
    public void saveTourFlight(TourFlight tourFlight) {
        Session session = sessionFactory.getCurrentSession();

        session.save(tourFlight);
    }
}
