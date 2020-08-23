package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Induccion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("induccionDaoJPA")
public class InduccionDaoImpl implements IInduccionDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Induccion> findAll() {
        return em.createQuery("from Induccion").getResultList();
    }

    @Override
    public void save(Induccion induccion) {
        if(induccion.getId() != null && induccion.getId() > 0){
            em.merge(induccion);
        }else{
            em.persist(induccion);
        }

    }

    @Override
    public Induccion findOne(Long id) {
        return em.find(Induccion.class, id);
    }

    @Override
    public void delete(Long id) {
        Induccion induccion = findOne(id);
        em.remove(induccion);
    }
}
