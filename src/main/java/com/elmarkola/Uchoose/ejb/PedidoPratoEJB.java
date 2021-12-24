package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.PedidoPrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class PedidoPratoEJB extends AbstractFacadeLocal<PedidoPrato> implements PedidoPratoFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public PedidoPratoEJB() {
        super(PedidoPrato.class);
    }

    public PedidoPratoEJB(Class<PedidoPrato> entityClass) {
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
