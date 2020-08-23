package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Sctrs;

import java.util.List;

public interface ISctrsDao {

    public List<Sctrs> findAll();

    public void save(Sctrs sctrs);

    public Sctrs findOne(Long id);

    public void delete(Long id);
}
