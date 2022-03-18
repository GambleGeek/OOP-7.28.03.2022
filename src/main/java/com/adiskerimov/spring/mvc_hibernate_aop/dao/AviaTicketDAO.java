package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.AviaTicket;

import java.util.List;

public interface AviaTicketDAO {
    public List<AviaTicket> getAll();
    public void save(AviaTicket aviaTicket);
    public AviaTicket get(int id);
    public void delete(int id);
}
