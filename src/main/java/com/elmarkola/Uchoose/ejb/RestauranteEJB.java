package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Restaurante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class RestauranteEJB extends AbstractFacadeLocal<Restaurante> implements RestauranteFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public RestauranteEJB() {
        super(Restaurante.class);
    }

    public RestauranteEJB(Class<Restaurante> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
}
