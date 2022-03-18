package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourPackage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourPackageDAOImpl implements TourPackageDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TourPackage> getAllTourPackages() {
        Session session = sessionFactory.getCurrentSession();

        Query<TourPackage> query = session.createQuery("from TourPackage", TourPackage.class);
        List<TourPackage> allTourPackages = query.getResultList();

        return allTourPackages;
    }

    @Override
    public void saveTourPackage(TourPackage tourPackage) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourPackage);
    }
}
