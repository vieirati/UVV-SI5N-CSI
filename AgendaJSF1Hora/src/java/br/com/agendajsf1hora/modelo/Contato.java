package br.com.agendajsf1hora.modelo;

import br.com.agendajsf1hora.controle.ContatoManagedBean;
import java.util.Objects;

/**
 *
 * @author Vieira
 */
public class Contato {
    private String nome, telefone, tpFone, tpContato, email;
    private Boolean favorito;

    public Contato() {
    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTpFone() {
        return tpFone;
    }

    public void setTpFone(String tpFone) {
        this.tpFone = tpFone;
    }

    public String getTpContato() {
        return tpContato;
    }

    public void setTpContato(String tpContato) {
        this.tpContato = tpContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
}
