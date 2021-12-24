package com.elmarkola.Uchoose.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.elmarkola.Uchoose.ejb.PedidoPratoFacadeLocal;
import com.elmarkola.Uchoose.entity.PedidoPrato;

@Named
@SessionScoped
public class PedidoPratoBean implements Serializable{

    @EJB
    private PedidoPratoFacadeLocal pedidoPratoEJB;

    private PedidoPrato pedidoPrato;

    private PedidoPrato pedidoPratoSelecionada;

    @PostConstruct
    public void init() {
        pedidoPrato = new PedidoPrato();
    }

    public PedidoPrato getPedidoPrato() {
        return pedidoPrato;
    }

    public void setPedidoPrato(PedidoPrato pedidoPrato) {
        this.pedidoPrato = pedidoPrato;
    }

    public PedidoPrato getPedidoPratoSelecionada() {
        return pedidoPratoSelecionada;
    }

    public void setPedidoPratoSelecionada(PedidoPrato pedidoPratoSelecionada) {
        this.pedidoPratoSelecionada = pedidoPratoSelecionada;
    }

    public String createPedidoPrato() {
        pedidoPratoEJB.create(pedidoPrato);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String updatePedidoPrato() {
        pedidoPratoEJB.update(pedidoPratoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deletePedidoPrato() {
        pedidoPratoEJB.remove(pedidoPratoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public List<PedidoPrato> findAllPedidoPrato() {
        return pedidoPratoEJB.findAll();
    }

    public void clear() {      
        
        pedidoPrato.setPrato(null);
        pedidoPrato.setPedido(null);
        pedidoPrato.setSubtotal(null);
        pedidoPrato.setComentarios(null);
        pedidoPrato.setQuantidade(null);



    }
}
