package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Colaborador;
import com.springboot.app.models.entity.Induccion;

import java.util.List;

public interface IColaboradorDao {

    public List<Colaborador> findAll();

    public void save(Colaborador colaborador);

    public Colaborador findOne(Long id);

    public void delete(Long id);
}
