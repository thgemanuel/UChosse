package com.elmarkola.Uchoose.bean;

import com.elmarkola.Uchoose.ejb.RestauranteFacadeLocal;
import com.elmarkola.Uchoose.entity.Prato;
import com.elmarkola.Uchoose.entity.Restaurante;
import java.io.Serializable;
import static java.lang.Integer.getInteger;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RestauranteBean implements Serializable {

    @EJB
    private RestauranteFacadeLocal restauranteEJB;

    private Restaurante restaurante;

    private Restaurante restauranteSelecionada;
    
    private List<Restaurante> restaurantesFiltrados;

    
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);
 
        Restaurante restaurante = (Restaurante) value;
        return restaurante .getNomeRestaurante().toLowerCase().contains(filterText);
    }
    
    
    
    
    public List<Restaurante> getRestaurantesFiltrados() {
        return restaurantesFiltrados;
    }

    public void setRestaurantesFiltrados(List<Restaurante> restaurantesFiltrados) {
        this.restaurantesFiltrados = restaurantesFiltrados;
    }

    //private Prato novoPrato;

    public String adicionarCardapio(Prato novoPrato) {
        restauranteSelecionada.getCardapio().add(novoPrato);
        restauranteEJB.update(restauranteSelecionada);
        return "gerenciarRestaurante.xhtml?faces-redirect=true";
    }

    public String excluirCardapio(Prato prato) {
        restauranteSelecionada.getCardapio().remove(prato);
        restauranteEJB.update(restauranteSelecionada);
        return "gerenciarRestaurante.xhtml?faces-redirect=true";
    }

    public String salvarClienteCardapios() {
        restauranteEJB.update(restauranteSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public void retirarCardapio() {
        restauranteSelecionada.setCardapio(null);
    }

    @PostConstruct
    public void init() {
        restaurante = new Restaurante();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Restaurante getRestauranteSelecionada() {
        return restauranteSelecionada;
    }

    public void setRestauranteSelecionada(Restaurante restauranteSelecionada) {
        this.restauranteSelecionada = restauranteSelecionada;
    }

    public String createRestaurante() {
        restauranteEJB.create(restaurante);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String updateRestaurante() {
        restauranteEJB.update(restauranteSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteRestaurante() {
        restauranteEJB.remove(restauranteSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public List<Restaurante> findAllRestaurante() {
        return restauranteEJB.findAll();
    }
    public Restaurante findRestaurante(Object id) {
       return restauranteEJB.find(id);
    }
    public String goTo()
    {
        return  "carrinho.xhtml?faces-redirect=true";
    }
    
    public void clear() {

        restaurante.setNomeRestaurante(null);
        restaurante.setBloqueado(false);
        restaurante.setTelefone(null);
        restaurante.setEmail(null);
        restaurante.setValorTaxaEntrega(0); //verificar
        restaurante.setCnpj(null);
        restaurante.setAberto(true);
        restaurante.setHorarioAtendimento(null);
        restaurante.setDisponivel(true);
        restaurante.setEstrelas(null);
        restaurante.setCardapio(null);
        restaurante.setEndereco(null);
        restaurante.setDescricao(null);

    }
}
