package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Order;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramDAOImpl implements ProgramDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Program> getAllPrograms() {
        Session session = sessionFactory.getCurrentSession();

        Query<Program> query = session.createQuery("from Program", Program.class);
        List<Program> allPrograms = query.getResultList();

        return allPrograms;
    }

    @Override
    public void saveProgram(Program program) {
        Session session = sessionFactory.getCurrentSession();
        session.save(program);
    }
}
