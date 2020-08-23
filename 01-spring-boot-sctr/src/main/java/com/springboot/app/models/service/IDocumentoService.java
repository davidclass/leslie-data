package com.springboot.app.models.service;

import com.springboot.app.models.entity.Documento;

import java.util.List;

public interface IDocumentoService {

    public List<Documento> findAll();

    public void save(Documento documento);

    public Documento findOne(Long id);

    public void delete(Long id);
}
