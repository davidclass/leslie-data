package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Sctrp;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("sctrpDaoJPA")
public class SctrpDaoImpl implements ISctrpDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sctrp> findAll() {
        return em.createQuery("from Sctrp ").getResultList();
    }

    @Override
    public void save(Sctrp sctrp) {
        if(sctrp.getId() != null && sctrp.getId() > 0){
            em.merge(sctrp);
        }else{
            em.persist(sctrp);
        }

    }

    @Override
    public Sctrp findOne(Long id) {
        return em.find(Sctrp.class, id);
    }

    @Override
    public void delete(Long id) {
        Sctrp sctrp = findOne(id);
        em.remove(sctrp);
    }
}
