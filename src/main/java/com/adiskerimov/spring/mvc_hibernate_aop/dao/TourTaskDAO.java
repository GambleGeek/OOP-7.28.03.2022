package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.*;

import java.util.List;

public interface TourTaskDAO {

    public List<TourTask> getAllTourTasks();

    public void saveTourTask(TourTask tourTask);

    public void deleteTourTask(int id);

    public TourTask get(int id);

}
