package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.*;

import java.util.List;

public interface TourTypeDAO {

    public List<TourType> getAllTourTypes();

    public void saveTourType(TourType tourType);

}
