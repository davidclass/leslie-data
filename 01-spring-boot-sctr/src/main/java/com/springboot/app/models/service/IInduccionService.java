package com.springboot.app.models.service;

import com.springboot.app.models.entity.Induccion;

import java.util.List;

public interface IInduccionService {

    public List<Induccion> findAll();

    public void save(Induccion induccion);

    public Induccion findOne(Long id);

    public void delete(Long id);
}
