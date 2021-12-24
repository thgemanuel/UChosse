package com.elmarkola.Uchoose.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.elmarkola.Uchoose.ejb.ClienteFacadeLocal;
import com.elmarkola.Uchoose.entity.Cliente;
import com.elmarkola.Uchoose.bean.Crypto;
import com.elmarkola.Uchoose.entity.Endereco;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcus
 */
@Named
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteEJB;

    private Cliente cliente;

    private Cliente clienteSelecionada;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }   
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSelecionada() {
        return clienteSelecionada;
    }

    public void setClienteSelecionada(Cliente clienteSelecionada) {
        this.clienteSelecionada = clienteSelecionada;
    }

    public String createCliente() {
        try {
            cliente.setSenha(Crypto.encodeSHA256(cliente.getSenha()));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(">>> UsuarioBean/createUsuario()/usuario: "
                + cliente);

        clienteEJB.create(cliente);
        clear();

        return "login_1.xhtml?faces-redirect=true";
    }

    public String updateCliente() {
        clienteEJB.update(clienteSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteCliente() {
        clienteEJB.remove(clienteSelecionada);
        return "index.xhtml?faces-redirect=true";
    }

    public List<Cliente> findAllCliente() {
        return clienteEJB.findAll();
    }
     public String logout() {
      HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
      sessao.invalidate();
      return "/index.xhtml"; //AQUI EU PASSO O NOME DA MINHA TELA INICIAL.
    }

    public void clear() {
        cliente.setNome(null);
        cliente.setEmail(null);
        cliente.setTelefone(null);
        cliente.setEndereco(null);
        cliente.setCpf(null);
        cliente.setSenha(null);
        cliente.setPapel("clienteuser");
        cliente.setBloqueado(false);
        cliente.setGerente(false);
        cliente.setRestaurante(null);

    }
}
