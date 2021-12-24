package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteFacadeLocal {

    public void create(Cliente cliente);

    public void update(Cliente cliente);

    public void remove(Cliente cliente);

    public Cliente find(Object id);

    public List<Cliente> findAll();

    public Integer count();
}
