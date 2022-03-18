package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.Hotel;

import java.util.List;

public interface HotelDAO {
    public List<Hotel> getAll();
    public void save(Hotel hotel);
    public Hotel get(int id);
    public void delete(int id);
}
