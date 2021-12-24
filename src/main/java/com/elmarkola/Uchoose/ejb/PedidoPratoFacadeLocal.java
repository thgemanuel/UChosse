package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.PedidoPrato;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidoPratoFacadeLocal {

    public void create(PedidoPrato endereco);

    public void update(PedidoPrato endereco);

    public void remove(PedidoPrato endereco);

    public PedidoPrato find(Object id);

    public List<PedidoPrato> findAll();

    public Integer count();
}
