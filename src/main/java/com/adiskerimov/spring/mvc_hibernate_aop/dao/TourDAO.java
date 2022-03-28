package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Room;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;

import java.util.List;

public interface TourDAO {

    public List<Tour> getAllTours();

    public void saveTour(Tour tour);

    public void deleteTour(int id);

    public Tour get(int id);
}
