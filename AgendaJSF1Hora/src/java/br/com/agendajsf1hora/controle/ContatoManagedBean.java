/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajsf1hora.controle;

import br.com.agendajsf1hora.DAO.ContatoDAO;
import br.com.agendajsf1hora.modelo.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vieira
 */
@ManagedBean(name = "ContatoBean")
@RequestScoped
public class ContatoManagedBean {
//===============================================================================================================================================================================================
    private Contato contato = new Contato();
    private List<Contato> listaContatosManaged;
    private ContatoDAO cDAO = new ContatoDAO();
//===============================================================================================================================================================================================
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Contato> getListaContatosManaged() {
        return listaContatosManaged = cDAO.listarContatosDAO();
    }

    public void setListaContatosManaged(List<Contato> listaContatosManaged) {
        this.listaContatosManaged = listaContatosManaged;
    }

    public ContatoDAO getcDAO() {
        return cDAO;
    }

    public void setcDAO(ContatoDAO cDAO) {
        this.cDAO = cDAO;
    }
//===============================================================================================================================================================================================    
    public String mensagemErro(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "SEVERITY_WARN: Campo Obrigatório", "Preencimento Obrigatório"));
        return null;
    }
    
    public String cadastroSucesso(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MENSAGEM: Você foi encaminhado para a página solicitada", "Cadastro OK!"));
        return "cadIndex";
    }
    public String cadastroCancelado(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MENSAGEM: Você foi encaminhado para a página solicitada", "Cadastro Cancelado..."));
        return null;
    }
//===============================================================================================================================================================================================    
    public String cadastrarContatoManaged(){
        cDAO.cadastrarContatoDAO(contato);
        return "Falha no Cadastro";
    }
    
//    public void listarContatosManaged(){
//        listaContatosManaged = cDAO.listarContatosDAO();
//    }
//===============================================================================================================================================================================================
}
