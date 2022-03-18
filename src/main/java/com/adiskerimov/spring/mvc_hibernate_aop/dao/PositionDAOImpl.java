package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Position> getAllPositions() {
        Session session = sessionFactory.getCurrentSession();

        Query<Position> query = session.createQuery("from Position", Position.class);
        List<Position> allPositions = query.getResultList();

        return allPositions;
    }

    @Override
    public void savePosition(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.save(position);
    }
}
