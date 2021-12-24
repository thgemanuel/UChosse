package com.elmarkola.Uchoose.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author marcus
 */
@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoRestaurante;
    private String nomeRestaurante;
    private boolean bloqueado;
    private String telefone;
    private String email;
    private double valorTaxaEntrega;
    @Column(length=50, nullable = false)
    private String cnpj;
    private boolean aberto;
    private String horarioAtendimento;
    private boolean disponivel;
    private Integer estrelas;
    private String descricao;
    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "cardapio_id")
    private List<Prato> cardapio;
    



    /**
     * @return the codigoRestaurante
     */
    public Integer getCodigoRestaurante() {
        return codigoRestaurante;
    }

    /**
     * @param codigoRestaurante the codigoRestaurante to set
     */
    public void setCodigoRestaurante(Integer codigoRestaurante) {
        this.codigoRestaurante = codigoRestaurante;
    }

    /**
     * @return the nomeRestaurante
     */
    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    /**
     * @param nomeRestaurante the nomeRestaurante to set
     */
    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    /**
     * @return the bloqueado
     */
    public boolean isBloqueado() {
        return bloqueado;
    }

    /**
     * @param bloqueado the bloqueado to set
     */
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the valorTaxaEntrega
     */
    public double getValorTaxaEntrega() {
        return valorTaxaEntrega;
    }

    /**
     * @param valorTaxaEntrega the valorTaxaEntrega to set
     */
    public void setValorTaxaEntrega(double valorTaxaEntrega) {
        this.valorTaxaEntrega = valorTaxaEntrega;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the aberto
     */
    public boolean isAberto() {
        return aberto;
    }

    /**
     * @param aberto the aberto to set
     */
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    /**
     * @return the horarioAtendimento
     */
    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    /**
     * @param horarioAtendimento the horarioAtendimento to set
     */
    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    /**
     * @return the disponivel
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the disponivel to set
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * @return the estrelas
     */
    public Integer getEstrelas() {
        return estrelas;
    }

    /**
     * @param estrelas the estrelas to set
     */
    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the cardapio
     */
    public List<Prato> getCardapio() {
        return cardapio;
    }

    /**
     * @param cardapio the cardapio to set
     */
    public void setCardapio(List<Prato> cardapio) {
        this.cardapio = cardapio;
    }
}
