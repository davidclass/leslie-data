package com.springboot.app.models.service;

import com.springboot.app.models.entity.Carnets;

import java.util.List;

public interface ICarnetsService {

    public List<Carnets> findAll();

    public void save(Carnets carnets);

    public Carnets findOne(Long id);

    public void delete(Long id);
}
