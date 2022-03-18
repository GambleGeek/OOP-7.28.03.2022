package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> getAll();
    public void save(Category category);
    public Category get(int id);
    public void delete(int id);
}
