package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Carnets;
import com.springboot.app.models.entity.Induccion;
import com.springboot.app.models.entity.Sctrs;

import java.util.List;

public interface ICarnetsDao {

    public List<Carnets> findAll();

    public void save(Carnets carnets);

    public Carnets findOne(Long id);

    public void delete(Long id);
}
