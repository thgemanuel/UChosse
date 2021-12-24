package com.elmarkola.Uchoose.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.elmarkola.Uchoose.ejb.EnderecoFacadeLocal;
import com.elmarkola.Uchoose.entity.Endereco;

@Named
@SessionScoped
public class EnderecoBean implements Serializable{

    @EJB
    private EnderecoFacadeLocal enderecoEJB;

    private Endereco endereco;

    private Endereco enderecoSelecionada;

    @PostConstruct
    public void init() {
        endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEnderecoSelecionada() {
        return enderecoSelecionada;
    }

    public void setEnderecoSelecionada(Endereco enderecoSelecionada) {
        this.enderecoSelecionada = enderecoSelecionada;
    }

    public String createEndereco() {
        enderecoEJB.create(endereco);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String updateEndereco() {
        enderecoEJB.update(enderecoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteEndereco() {
        enderecoEJB.remove(enderecoSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public List<Endereco> findAllEndereco() {
        return enderecoEJB.findAll();
    }

    public void clear() {      

        endereco.setCep(null);
        endereco.setNumero(null);
        endereco.setCidade(null);
        endereco.setBairro(null);
        endereco.setEstado(null);
        endereco.setComplemento(null);
        endereco.setRua(null);

    }
}
