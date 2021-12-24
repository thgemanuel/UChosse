package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Endereco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless //diz que é uma EJB
public class EnderecoEJB extends AbstractFacadeLocal<Endereco> implements EnderecoFacadeLocal {

    @PersistenceContext(unitName = "PerUchoose")
    private EntityManager entityManager;
    public EnderecoEJB() {
        super(Endereco.class);
    }

    public EnderecoEJB(Class<Endereco> entityClass) {
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
