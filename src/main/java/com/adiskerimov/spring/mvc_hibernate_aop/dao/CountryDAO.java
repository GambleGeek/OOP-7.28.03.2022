package com.adiskerimov.spring.mvc_hibernate_aop.dao;


import com.adiskerimov.spring.mvc_hibernate_aop.entity.Country;

import java.util.List;

public interface CountryDAO {
    public List<Country> getAll();
    public void save(Country country);
    public Country get(int id);
    public void delete(int id);
}
