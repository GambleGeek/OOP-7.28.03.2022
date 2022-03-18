package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.Contract;

import java.util.List;

public interface ContractDAO {
    public List<Contract> getAll();
    public void save(Contract contract);
    public Contract get(int id);
    public void delete(int id);
}
