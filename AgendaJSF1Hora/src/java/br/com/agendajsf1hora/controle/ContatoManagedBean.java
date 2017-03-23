/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajsf1hora.controle;

import br.com.agendajsf1hora.modelo.Contato;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vieira
 */
@ManagedBean(name = "ContatoBean")
@RequestScoped
public class ContatoManagedBean {
    private Contato contato = new Contato();

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    
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
    
//    public String validaCampos(){
//        if(contato.getNome().equals(null) || contato.getTelefone().equals(null)){
//            return mensagemErro();
//        }
//        else{
//            return cadastroSucesso();
//        }
//        
//    }
}
