package com.elmarkola.Uchoose.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractFacadeLocal<T> {
    
    private final Class<T> entityClass;

    public AbstractFacadeLocal(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity) {
        getEntityManager().persist(entity);//metodo para persistir no BD
    }

    public void update(T entity) {
        getEntityManager().merge(entity);//da um merge na entidade que estou recebendo no BD
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));//remove o cara que ta no BD
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);//encontra alguem no BD, o q foi passado o id
    }

    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));//seleção sem criterio, portanto retorna tudo
        return getEntityManager().createQuery(cq).getResultList();
    }

    public Integer count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();//objeto para fazer a consulta
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);//faz a contagem
        return ((Long) q.getSingleResult()).intValue();//devolve quantos valores foram retornados
    }
    
}
