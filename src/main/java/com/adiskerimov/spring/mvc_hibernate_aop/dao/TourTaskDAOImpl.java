package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourFlight;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.TourTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourTaskDAOImpl implements TourTaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TourTask> getAllTourTasks() {
        Session session = sessionFactory.getCurrentSession();

        Query<TourTask> query = session.createQuery("from TourTask", TourTask.class);
        List<TourTask> allTourTasks = query.getResultList();

        return allTourTasks;
    }

    @Override
    public void saveTourTask(TourTask tourTask) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tourTask);
    }

    @Override
    public void deleteTourTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<TourTask> query = session.createQuery("delete from TourTask " +
                "where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public TourTask get(int id) {
        Session session = sessionFactory.getCurrentSession();
        TourTask tourTask = session.get(TourTask.class, id);
        return tourTask;
    }
}
