package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.*;

import java.util.List;

public interface TourPackageDAO {

    public List<TourPackage> getAllTourPackages();

    public void saveTourPackage(TourPackage tourPackage);

}
