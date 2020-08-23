package com.springboot.app.models.service;

import com.springboot.app.models.dao.IDodumentoDao;
import com.springboot.app.models.entity.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("documentoServiceJPA")
public class DocumentoServiceImpl implements IDocumentoService{

    @Autowired
    @Qualifier("documentoDaoJPA")
    private IDodumentoDao dodumentoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Documento> findAll() {
        return dodumentoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Documento documento) {
        dodumentoDao.save(documento);
    }

    @Override
    @Transactional(readOnly = true)
    public Documento findOne(Long id) {
        return dodumentoDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dodumentoDao.delete(id);
    }
}
