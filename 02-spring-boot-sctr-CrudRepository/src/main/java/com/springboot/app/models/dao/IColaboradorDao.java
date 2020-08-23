package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Colaborador;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IColaboradorDao extends PagingAndSortingRepository<Colaborador, Long> {


}
