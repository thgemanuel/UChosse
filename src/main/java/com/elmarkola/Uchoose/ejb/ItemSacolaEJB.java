package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.ItemSacola;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class ItemSacolaEJB extends AbstractFacadeLocal<ItemSacola> implements ItemSacolaFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public ItemSacolaEJB() {
        super(ItemSacola.class);
    }

    public ItemSacolaEJB(Class<ItemSacola> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

   /* @Override
    public void create(Cliente ordemServico) {
        ordemServico.setCriacao(new Date());
        getEntityManager().persist(ordemServico);
    }*/

}
