package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.ClassAvia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassAviaDAOImpl implements ClassAviaDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ClassAvia get(int id) {
        Session session = sessionFactory.getCurrentSession();
        ClassAvia classAvia = session.get(ClassAvia.class, id);
        return classAvia;
    }

    @Override
    public List<ClassAvia> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<ClassAvia> query = session.createQuery("from ClassAvia", ClassAvia.class);
        List<ClassAvia> classAvias = query.getResultList();
        return classAvias;
    }
    
    @Override
    public void save(ClassAvia classAvia) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(classAvia);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<ClassAvia> query = session.createQuery("delete from ClassAvia " +
                "where id =:classAviaId");
        query.setParameter("classAviaId", id);
        query.executeUpdate();
    }
}
