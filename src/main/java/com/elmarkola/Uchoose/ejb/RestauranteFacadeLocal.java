package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Restaurante;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RestauranteFacadeLocal {

    public void create(Restaurante restaurante);

    public void update(Restaurante restaurante);

    public void remove(Restaurante restaurante);

    public Restaurante find(Object id);

    public List<Restaurante> findAll();

    public Integer count();
}
