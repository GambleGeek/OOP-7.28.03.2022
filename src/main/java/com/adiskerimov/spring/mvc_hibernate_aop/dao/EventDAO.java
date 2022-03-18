package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.Event;

import java.util.List;

public interface EventDAO {
    public List<Event> getAll();
    public void save(Event event);
    public Event get(int id);
    public void delete(int id);
}
