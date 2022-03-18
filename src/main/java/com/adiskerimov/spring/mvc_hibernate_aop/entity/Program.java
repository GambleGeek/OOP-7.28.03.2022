package com.adiskerimov.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @OneToMany(cascade = {CascadeType.ALL},
//    mappedBy = "program")
//    private int program_number;

    @Column
    private int program_number;

    @Column
    @NotEmpty(message="Name should not be empty")
    @Size(min = 5, message = "Size should be greater than 5 symbols")
    private String description;

    public Program() {
    }

    public Program(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProgram_number() {
        return program_number;
    }

    public void setProgram_number(int program_number) {
        this.program_number = program_number;
    }

    //    public int getProgram_number() {
//        return program_number;
//    }
//
//    public void setProgram_number(int program_number) {
//        this.program_number = program_number;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
