package com.springboot.app.models.dao;

import com.springboot.app.models.entity.Colaborador;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("colaboradorDaoJPA")
public class ColaboradorDaoImpl implements IColaboradorDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Colaborador> findAll() {
        return em.createQuery("from Colaborador").getResultList();
    }

    @Override
    public void save(Colaborador colaborador) {
        if(colaborador.getId() != null && colaborador.getId() > 0){
            System.out.println("12");
            em.merge(colaborador);
        }else{
            System.out.println("13");
            em.persist(colaborador);
        }
    }

    @Override
    public Colaborador findOne(Long id) {
        return em.find(Colaborador.class, id);
    }

    @Override
    public void delete(Long id) {
        Colaborador colaborador = findOne(id);
        em.remove(colaborador);

    }
}
