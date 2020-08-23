package com.springboot.app.models.service;

import com.springboot.app.models.dao.IInduccionDao;
import com.springboot.app.models.entity.Induccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("induccionServiceJPA")
public class InduccionServiceImpl implements IInduccionService{

    @Autowired
    @Qualifier("induccionDaoJPA")
    private IInduccionDao induccionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Induccion> findAll() {
        return induccionDao.findAll();
    }

    @Override
    @Transactional
    public void save(Induccion induccion) {
        induccionDao.save(induccion);
    }

    @Override
    @Transactional(readOnly = true)
    public Induccion findOne(Long id) {
        return induccionDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        induccionDao.delete(id);
    }
}
