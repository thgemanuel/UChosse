package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.ItemSacola;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ItemSacolaFacadeLocal {

    public void create(ItemSacola itemSacola);

    public void update(ItemSacola itemSacola);

    public void remove(ItemSacola itemSacola);

    public ItemSacola find(Object id);

    public List<ItemSacola> findAll();

    public Integer count();
}
