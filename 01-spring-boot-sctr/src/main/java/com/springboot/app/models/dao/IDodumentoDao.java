package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Documento;

import java.util.List;

public interface IDodumentoDao {

    public List<Documento> findAll();

    public void save(Documento documento);

    public Documento findOne(Long id);

    public void delete(Long id);
}
