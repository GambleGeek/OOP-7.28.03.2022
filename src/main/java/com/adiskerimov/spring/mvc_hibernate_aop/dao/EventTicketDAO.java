package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.EventTicket;

import java.util.List;

public interface EventTicketDAO {
    public List<EventTicket> getAll();
    public void save(EventTicket eventTicket);
    public EventTicket get(int id);
    public void delete(int id);
}
