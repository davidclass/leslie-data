package com.springboot.app.models.service;

import com.springboot.app.models.dao.ISctrpDao;
import com.springboot.app.models.entity.Sctrp;
import com.springboot.app.models.entity.Sctrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sctrpServiceJPA")
public class SctrpServiceImpl implements ISctrpService{

    @Autowired
    @Qualifier("sctrpDaoJPA")
    private ISctrpDao sctrpDao;

    @Override
    @Transactional(readOnly = true)
    public List<Sctrp> findAll() {
        return sctrpDao.findAll();
    }

    @Override
    @Transactional
    public void save(Sctrp sctrp) {
        sctrpDao.save(sctrp);
    }

    @Override
    @Transactional(readOnly = true)
    public Sctrp findOne(Long id) {
        return sctrpDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sctrpDao.delete(id);
    }
}
