package com.elmarkola.Uchoose.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
   // private Restaurante restaurante;
   // private Cliente cliente;
   // private Endereco enderecoEntrega= new Endereco();
    private String status;
    private double valorTotal;
    private double taxaEntrega;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;
    
//    @OneToMany(
//            mappedBy="Pedido",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JoinColumn(name = "pedido_id")
//    private List<PedidoPrato> pedidoprato;

        @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "itemSacola_id")    
    private ArrayList<PedidoPrato> itemSacola;

    public ArrayList<PedidoPrato> getItemSacola() {
        return itemSacola;
    }

    public void setItemSacola(ArrayList<PedidoPrato> itemSacola) {
        this.itemSacola = itemSacola;
    }
    
    /*    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PedidoPrato",
            joinColumns = {@JoinColumn(name = "pedido_id")},
            inverseJoinColumns = {@JoinColumn(name = "prato_id")}
    )
    
    private List<Prato> muitosPratos; 
*/
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the taxaEntrega
     */
    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    /**
     * @param taxaEntrega the taxaEntrega to set
     */
    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    /**
     * @return the dataPedido
     */
    public Date getDataPedido() {
        return dataPedido;
    }

    /**
     * @param dataPedido the dataPedido to set
     */
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    /*
    public List<Prato> getMuitosPratos() {
        return muitosPratos;
    }

    public void setMuitosPratos(List<Prato> muitosPratos) {
        this.muitosPratos = muitosPratos;
    }
    */

//    public List<PedidoPrato> getPedidoprato() {
//        return pedidoprato;
//    }
//
//    public void setPedidoprato(List<PedidoPrato> pedidoprato) {
//        this.pedidoprato = pedidoprato;
//    }


   
    /**
     * @param itemSacola the itemSacola to set
     */
//    public void setItemSacola(ArrayList<ItemSacola> itemSacola) {
//        this.itemSacola = itemSacola;
//    }
//
//    /**
//     * @return the itemSacola
//     */
//    public ArrayList<ItemSacola> getItemSacola() {
//        return itemSacola;
//    }
//    


}
