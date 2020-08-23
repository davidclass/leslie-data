package com.springboot.app.models.service;

import com.springboot.app.models.dao.ISctrsDao;
import com.springboot.app.models.entity.Sctrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sctrsServiceJPA")
public class SctrsServiceImpl implements ISctrsService{

    @Autowired
    @Qualifier("sctrsDaoJPA")
    private ISctrsDao sctrsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Sctrs> findAll() {
        return sctrsDao.findAll();
    }

    @Override
    @Transactional
    public void save(Sctrs sctrs) {
        sctrsDao.save(sctrs);
    }

    @Override
    @Transactional(readOnly = true)
    public Sctrs findOne(Long id) {
        return sctrsDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sctrsDao.delete(id);
    }
}
