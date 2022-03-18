package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Client;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Program;

import java.util.List;

public interface ProgramDAO {
    public List<Program> getAllPrograms();

    public void saveProgram(Program program);
}
