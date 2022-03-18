package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.AviaTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AviaTicketDAOImpl implements AviaTicketDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public AviaTicket get(int id) {
        Session session = sessionFactory.getCurrentSession();
        AviaTicket aviaTicket = session.get(AviaTicket.class, id);
        return aviaTicket;
    }

    @Override
    public List<AviaTicket> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<AviaTicket> query = session.createQuery("from AviaTicket", AviaTicket.class);
        List<AviaTicket> aviaTickets = query.getResultList();
        return aviaTickets;
    }
    
    @Override
    public void save(AviaTicket aviaTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(aviaTicket);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<AviaTicket> query = session.createQuery("delete from AviaTicket " +
                "where id =:aviaTicketId");
        query.setParameter("aviaTicketId", id);
        query.executeUpdate();
    }
}
