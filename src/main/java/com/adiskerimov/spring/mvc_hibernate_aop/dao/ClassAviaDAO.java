package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.ClassAvia;

import java.util.List;

public interface ClassAviaDAO {
    public List<ClassAvia> getAll();
    public void save(ClassAvia aviaClass);
    public ClassAvia get(int id);
    public void delete(int id);
}
