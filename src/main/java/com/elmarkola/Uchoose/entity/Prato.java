package com.elmarkola.Uchoose.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author marcus
 */
@Entity
@Table(name = "prato")
public class Prato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
//private Restaurante origem;
    private String nome;
    private double valorProduto;
        /**
    @ManyToMany(mappedBy = "muitosPratos")
    private List<Pedido> pedidos;
       */
    
    // todo mum para muitos -> itemprato: lista
    @OneToMany(
            mappedBy="Prato",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "prato_id")
    private List<PedidoPrato> pedidoprato;

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valorProduto
     */
    public double getValorProduto() {
        return valorProduto;
    }

    /**
     * @param valorProduto the valorProduto to set
     */
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public List<PedidoPrato> getPedidoprato() {
        return pedidoprato;
    }

    public void setPedidoprato(List<PedidoPrato> pedidoprato) {
        this.pedidoprato = pedidoprato;
    }

    /**
     * @return the pedidos

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param  the pedidos to set
     
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    
    */
}
