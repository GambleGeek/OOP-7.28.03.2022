package com.adiskerimov.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int passport_number;

    @Column
    @NotEmpty(message="Name should not be empty")
    @Size(min = 5, message = "Size should be greater than 5 symbols")
    private String name;

    @Column
    private char age;

    @Column
    @NotEmpty(message="Name should not be empty")
    @Size(min = 5, message = "Size should be greater than 5 symbols")
    private String address;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
    mappedBy = "tourist")
    private List<TourPackage> tourPackages;

    public Tourist() {
    }

    public Tourist(int passport_number, String name, char age, String address) {
        this.passport_number = passport_number;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(int passport_number) {
        this.passport_number = passport_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getAge() {
        return age;
    }

    public void setAge(char age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TourPackage> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(List<TourPackage> tourPackages) {
        this.tourPackages = tourPackages;
    }
}
