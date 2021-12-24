package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Prato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class PratoEJB extends AbstractFacadeLocal<Prato> implements PratoFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public PratoEJB() {
        super(Prato.class);
    }

    public PratoEJB(Class<Prato> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
}
