package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Pedido;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class PedidoEJB extends AbstractFacadeLocal<Pedido> implements PedidoFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public PedidoEJB() {
        super(Pedido.class);
    }

    public PedidoEJB(Class<Pedido> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void create(Pedido pedido) {
        pedido.setDataPedido(new Date());
        getEntityManager().persist(pedido);
    }

}
