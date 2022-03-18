package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.EventTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventTicketDAOImpl implements EventTicketDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public EventTicket get(int id) {
        Session session = sessionFactory.getCurrentSession();
        EventTicket eventTicket = session.get(EventTicket.class, id);
        return eventTicket;
    }

    @Override
    public List<EventTicket> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<EventTicket> query = session.createQuery("from EventTicket", EventTicket.class);
        List<EventTicket> eventTickets = query.getResultList();
        return eventTickets;
    }
    
    @Override
    public void save(EventTicket eventTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(eventTicket);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<EventTicket> query = session.createQuery("delete from EventTicket " +
                "where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
