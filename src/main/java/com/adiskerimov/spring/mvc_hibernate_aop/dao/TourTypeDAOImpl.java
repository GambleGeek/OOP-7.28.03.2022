package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourTypeDAOImpl implements TourTypeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TourType> getAllTourTypes() {
        Session session = sessionFactory.getCurrentSession();

        Query<TourType> query = session.createQuery("from TourType", TourType.class);
        List<TourType> allTourTypes = query.getResultList();

        return allTourTypes;
    }

    @Override
    public void saveTourType(TourType tourType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourType);
    }
}
