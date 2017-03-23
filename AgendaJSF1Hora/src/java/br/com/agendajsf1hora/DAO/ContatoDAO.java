/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajsf1hora.DAO;

import br.com.agendajsf1hora.modelo.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vieira
 */
public class ContatoDAO {
    private static List<Contato> contatos = new ArrayList<Contato>();
    
    public void cadastrarContatoDAO(Contato contato){
        if(contatos.add(contato)){
            System.out.println("Cadastrando o contato: " + contato.getNome() + "\nTelefone: " + contato.getTelefone());
            System.out.println("Obs.: Total de contatos Cadastrados: " + contatos.size());
        }
        else{
            System.out.println("Falha ao cadastrar Contato");
        }
    }
    
    public List<Contato> listarContatosDAO(){
        System.out.println("Recuperando lista de contatos...\nTotal de contatos cadastrados: " + contatos.size());
        return contatos;
    }
}
