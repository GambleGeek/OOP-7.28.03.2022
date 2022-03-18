package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.ClassHotel;

import java.util.List;

public interface ClassHotelDAO {
    public List<ClassHotel> getAll();
    public void save(ClassHotel classHotel);
    public ClassHotel get(int id);
    public void delete(int id);
}
