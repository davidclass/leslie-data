package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Documento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("documentoDaoJPA")
public class DocumentoDaoImpl implements IDodumentoDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Documento> findAll() {
        return em.createQuery("from Documento").getResultList();
    }

    @Override
    public void save(Documento documento) {
        if(documento.getId() != null && documento.getId() > 0){
            em.merge(documento);
        }else{
            em.persist(documento);
        }
    }

    @Override
    public Documento findOne(Long id) {
        return em.find(Documento.class, id);
    }

    @Override
    public void delete(Long id) {
        Documento documento = findOne(id);
        em.remove(documento);
    }
}
