package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Room;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tourist;

import java.util.List;

public interface TouristDAO {

    public List<Tourist> getAllTourists();

    public void saveTourist(Tourist tourist);




}
