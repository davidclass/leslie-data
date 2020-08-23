package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Sctrp;

import java.util.List;

public interface ISctrpDao {

    public List<Sctrp> findAll();

    public void save(Sctrp sctrp);

    public Sctrp findOne(Long id);

    public void delete(Long id);
}
