package com.springboot.app.models.service;

import com.springboot.app.models.dao.IColaboradorDao;
import com.springboot.app.models.entity.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("colaboradorServiceJPA")
public class ColaboradorServiceImpl implements IColaboradorService{

    @Autowired
    @Qualifier("colaboradorDaoJPA")
    private IColaboradorDao colaboradorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Colaborador> findAll() {
        return colaboradorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Colaborador colaborador) {
        colaboradorDao.save(colaborador);
    }

    @Override
    @Transactional(readOnly = true)
    public Colaborador findOne(Long id) {
        return colaboradorDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        colaboradorDao.delete(id);
    }
}
