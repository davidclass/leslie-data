package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Induccion;

import java.util.List;

public interface IInduccionDao {

    public List<Induccion> findAll();

    public void save(Induccion induccion);

    public Induccion findOne(Long id);

    public void delete(Long id);
}
