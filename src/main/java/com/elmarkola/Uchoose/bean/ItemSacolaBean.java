package com.elmarkola.Uchoose.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.elmarkola.Uchoose.ejb.ItemSacolaFacadeLocal;
import com.elmarkola.Uchoose.entity.Endereco;
import com.elmarkola.Uchoose.entity.ItemSacola;

@Named
@SessionScoped
public class ItemSacolaBean implements Serializable{

    @EJB
    private ItemSacolaFacadeLocal itemSacolaEJB;

    private ItemSacola itemSacola;

    private ItemSacola itemSacolaSelecionada;

    @PostConstruct
    public void init() {
        itemSacola = new ItemSacola();
    }

    public ItemSacola getItemSacola() {
        return itemSacola;
    }

    public void setItemSacola(ItemSacola itemSacola) {
        this.itemSacola = itemSacola;
    }

    public ItemSacola getItemSacolaSelecionada() {
        return itemSacolaSelecionada;
    }

    public void setItemSacolaSelecionada(ItemSacola itemSacolaSelecionada) {
        this.itemSacolaSelecionada = itemSacolaSelecionada;
    }

    public String createItemSacola() {
        itemSacolaEJB.create(itemSacola);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String updateItemSacola() {
        itemSacolaEJB.update(itemSacolaSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteItemSacola() {
        itemSacolaEJB.remove(itemSacolaSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public List<ItemSacola> findAllItemSacola() {
        return itemSacolaEJB.findAll();
    }

    public void clear() {      

        itemSacola.setSubtotal(0);
        itemSacola.setQuantidade(0);
        itemSacola.setComentarios(null);
        itemSacola.setPrato(null);        

    }
}
