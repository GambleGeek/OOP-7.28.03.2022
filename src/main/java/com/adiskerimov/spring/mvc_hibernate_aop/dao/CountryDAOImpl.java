package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Country get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.get(Country.class, id);
        return country;
    }

    @Override
    public List<Country> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Country> query = session.createQuery("from Country", Country.class);
        List<Country> countries = query.getResultList();
        return countries;
    }

    @Override
    public void save(Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(country);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Country> query = session.createQuery("delete from Country " +
                "where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
