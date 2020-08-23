package com.springboot.app.models.service;

import com.springboot.app.models.entity.Sctrs;

import java.util.List;

public interface ISctrsService {

    public List<Sctrs> findAll();

    public void save(Sctrs sctrs);

    public Sctrs findOne(Long id);

    public void delete(Long id);
}
