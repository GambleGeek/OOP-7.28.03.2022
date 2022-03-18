package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Contract get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Contract contract = session.get(Contract.class, id);
        return contract;
    }

    @Override
    public List<Contract> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Contract> query = session.createQuery("from Contract", Contract.class);
        List<Contract> contracts = query.getResultList();
        return contracts;
    }
    
    @Override
    public void save(Contract contract) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(contract);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Contract> query = session.createQuery("delete from Contract " +
                "where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
