package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Carnets;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("carnetsDaoJPA")
public class CarnetsDaoImpl implements ICarnetsDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Carnets> findAll() {
        return em.createQuery("from Carnets").getResultList();
    }

    @Override
    public void save(Carnets carnets) {
        if(carnets.getId() != null && carnets.getId() > 0){
            em.merge(carnets);
        }else{
            em.persist(carnets);
        }
    }

    @Override
    public Carnets findOne(Long id) {
        return em.find(Carnets.class, id);
    }

    @Override
    public void delete(Long id) {
        Carnets carnets = findOne(id);
        em.remove(carnets);
    }
}
