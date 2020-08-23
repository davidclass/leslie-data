package com.springboot.app.models.service;

import com.springboot.app.models.entity.Sctrp;

import java.util.List;

public interface ISctrpService {

    public List<Sctrp> findAll();

    public void save(Sctrp sctrp);

    public Sctrp findOne(Long id);

    public void delete(Long id);
}
