package com.springboot.app.models.service;

import com.springboot.app.models.dao.ICarnetsDao;
import com.springboot.app.models.entity.Carnets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carnetsServiceJPA")
public class ICarnetsServiceImpl implements ICarnetsService{

    @Autowired
    @Qualifier("carnetsDaoJPA")
    private ICarnetsDao carnetsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Carnets> findAll() {
        return carnetsDao.findAll();
    }

    @Override
    @Transactional
    public void save(Carnets carnets) {
        carnetsDao.save(carnets);
    }

    @Override
    @Transactional(readOnly = true)
    public Carnets findOne(Long id) {
        return carnetsDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carnetsDao.delete(id);
    }
}
