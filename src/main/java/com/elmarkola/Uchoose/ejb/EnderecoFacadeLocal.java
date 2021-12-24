package com.elmarkola.Uchoose.ejb;

import com.elmarkola.Uchoose.entity.Endereco;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EnderecoFacadeLocal {

    public void create(Endereco endereco);

    public void update(Endereco endereco);

    public void remove(Endereco endereco);

    public Endereco find(Object id);

    public List<Endereco> findAll();

    public Integer count();
}
