package com.elmarkola.Uchoose.bean;

import com.elmarkola.Uchoose.ejb.PratoFacadeLocal;
import com.elmarkola.Uchoose.entity.Prato;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PratoBean implements Serializable{

    @EJB
    private PratoFacadeLocal pratoEJB;

    private Prato prato;

    private Prato pratoSelecionada;

    @PostConstruct
    public void init() {
        prato = new Prato();
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public Prato getPratoSelecionada() {
        return pratoSelecionada;
    }

    public void setPratoSelecionada(Prato pratoSelecionada) {
        this.pratoSelecionada = pratoSelecionada;
    }

    public String createPrato() {
        pratoEJB.create(prato);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String updatePrato() {
        pratoEJB.update(pratoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deletePrato() {
        pratoEJB.remove(pratoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public List<Prato> findAllPrato() {
        return pratoEJB.findAll();
    }

    public void clear() {      
        
        //prato.setOrigem(null);
        prato.setNome(null);
        prato.setValorProduto(0);//verificar
    }
    
}
