package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class ClienteEJB extends AbstractFacadeLocal<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public ClienteEJB() {
        super(Cliente.class);
    }

    public ClienteEJB(Class<Cliente> entityClass) {
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
