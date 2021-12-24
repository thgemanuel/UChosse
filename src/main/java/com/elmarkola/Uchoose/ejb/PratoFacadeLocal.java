package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Prato;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PratoFacadeLocal {

    public void create(Prato prato);

    public void update(Prato prato);

    public void remove(Prato prato);

    public Prato find(Object id);

    public List<Prato> findAll();

    public Integer count();
}
