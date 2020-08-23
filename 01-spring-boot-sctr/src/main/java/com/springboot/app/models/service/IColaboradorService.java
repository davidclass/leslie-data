package com.springboot.app.models.service;

import com.springboot.app.models.entity.Colaborador;

import java.util.List;

public interface IColaboradorService {

    public List<Colaborador> findAll();

    public void save(Colaborador colaborador);

    public Colaborador findOne(Long id);

    public void delete(Long id);
}
