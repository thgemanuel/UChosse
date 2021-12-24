package com.elmarkola.Uchoose.bean;

import com.elmarkola.Uchoose.ejb.PedidoFacadeLocal;
import com.elmarkola.Uchoose.entity.Cliente;
import com.elmarkola.Uchoose.entity.Endereco;
import com.elmarkola.Uchoose.entity.ItemSacola;
import com.elmarkola.Uchoose.entity.Pedido;
import com.elmarkola.Uchoose.entity.Restaurante;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PedidoBean implements Serializable{

    @EJB
    private PedidoFacadeLocal pedidoEJB;

    private Pedido pedido;

    private Pedido pedidoSelecionada;

    @PostConstruct
    public void init() {
        pedido = new Pedido();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedidoSelecionada() {
        return pedidoSelecionada;
    }

    public void setPedidoSelecionada(Pedido pedidoSelecionada) {
        this.pedidoSelecionada = pedidoSelecionada;
    }

    public String createPedido() {
        pedidoEJB.create(pedido);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String updatePedido() {
        pedidoEJB.update(pedidoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deletePedido() {
        pedidoEJB.remove(pedidoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    
  
    public List<Pedido> findAllPedido() {
        return pedidoEJB.findAll();
    }
    
   

    public void clear() { 
        
       // pedido.setRestaurante(null);
       // pedido.setCliente(null);
       // pedido.setEnderecoEntrega(null);
        pedido.setStatus(null);
        pedido.setValorTotal(0);//verificar
        pedido.setTaxaEntrega(0);//verificar
        pedido.setDataPedido(null);

    }
}
