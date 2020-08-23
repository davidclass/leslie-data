package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Sctrs;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("sctrsDaoJPA")
public class ScrtsDaoImpl implements ISctrsDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sctrs> findAll() {
        return em.createQuery("from Sctrs").getResultList();
    }

    @Override
    public void save(Sctrs sctrs) {

        if(sctrs.getId() != null && sctrs.getId() > 0){
            em.merge(sctrs);
        }else{
            em.persist(sctrs);
        }


    }

    @Override
    public Sctrs findOne(Long id) {
        return em.find(Sctrs.class, id);
    }

    @Override
    public void delete(Long id) {
        Sctrs sctrs = findOne(id);
        em.remove(sctrs);
    }
}
