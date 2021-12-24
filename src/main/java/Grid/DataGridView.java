package Grid;

import com.elmarkola.Uchoose.ejb.RestauranteEJB;
import com.elmarkola.Uchoose.entity.Restaurante;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruce
 */
@Named
@ViewScoped
public class DataGridView implements Serializable {
     
    private List<Restaurante> restaurantes;
     
    private Restaurante restauranteSelecionada;
     
    @Inject
    private RestauranteEJB restauranteEJB;
     
    @PostConstruct
    public void init() {
        restaurantes = restauranteEJB.findAll();
    }
 
    public List<Restaurante> getRestaurante() {
        return restaurantes;
    }
 
    public void setService(RestauranteEJB restauranteEJB) {
        this.restauranteEJB = restauranteEJB;
    }
 
  

    public void setRestauranteSelecionada(Restaurante restauranteSelecionada) {
        this.restauranteSelecionada = restauranteSelecionada;
    }
 
   
}