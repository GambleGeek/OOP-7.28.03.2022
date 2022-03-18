package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Room;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Tour;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;

import java.util.List;

public interface TourFlightDAO {

    public List<TourFlight> getAllTourFlights();

    public void saveTourFlight(TourFlight tourFlight);

}
