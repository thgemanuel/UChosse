package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Pedido;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidoFacadeLocal {

    public void create(Pedido pedido);

    public void update(Pedido pedido);

    public void remove(Pedido pedido);

    public Pedido find(Object id);

    public List<Pedido> findAll();

    public Integer count();
}
