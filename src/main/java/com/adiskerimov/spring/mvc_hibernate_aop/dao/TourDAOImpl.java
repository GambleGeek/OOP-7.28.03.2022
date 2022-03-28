package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDAOImpl implements TourDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tour> getAllTours() {
        Session session = sessionFactory.getCurrentSession();

        Query<Tour> query = session.createQuery("from Tour", Tour.class);
        List<Tour> allTours = query.getResultList();

        return allTours;
    }

    @Override
    public void saveTour(Tour tour) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tour);
    }

    @Override
    public void deleteTour(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Tour> query = session.createQuery("delete from Tour " +
                "where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Tour get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Tour tour = session.get(Tour.class, id);
        return tour;
    }
}
