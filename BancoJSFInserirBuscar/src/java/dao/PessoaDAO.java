package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;
import tools.Gerenciador;

/**
 *
 * @author Vieira
 */
public class PessoaDAO {
    private Connection con = null;
    
    public boolean inserirPessoaDAO(Pessoa pessoa){
    boolean retorno = false;
    con = Gerenciador.abirConexao();
    String sql = "INSERT INTO `bancojsfinserirbuscar`.`pessoa`(`nome`,`endereco`,`cidade`,`telefone`) VALUES (?,?,?,?)";
    PreparedStatement stmt = null;
    
    try {
        stmt = con.prepareStatement(sql);
        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getEndereco());
        stmt.setString(3, pessoa.getCidade());
        stmt.setString(4, pessoa.getTelefone());
        stmt.executeUpdate();
        retorno = true;
    } catch (SQLException ex) {
        Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao inserir " + pessoa.getNome() + " no bando de dados...");
        retorno = false;
    }
    finally{
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao finalizar conexão com banco de dados");
        }
    }
    return retorno;
    }
    
    public Pessoa consultarPessoaDAO(Pessoa pessoa){
        con = Gerenciador.abirConexao();
        String sql = "SELECT `pessoa`.`nome`,`pessoa`.`endereco`,`pessoa`.`cidade`,`pessoa`.`telefone`FROM `bancojsfinserirbuscar`.`pessoa` WHERE `pessoa`.`nome` LIKE ? ";
        PreparedStatement stmt = null;
        ResultSet rset = null;
        Pessoa pessoaLida = null;
        try {
            stmt = con.prepareCall(sql);
            stmt.setString(1, pessoa.getNome()+"%");
            rset = stmt.executeQuery();
            
            if(rset.next()){
                pessoaLida = new Pessoa();
                pessoaLida.setNome(rset.getString("nome"));
                pessoaLida.setEndereco(rset.getString("endereco"));
                pessoaLida.setCidade(rset.getString("cidade"));
                pessoaLida.setTelefone(rset.getString("telefone"));
            }
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao recuperar dados de " + pessoa.getNome());
            pessoaLida = null;
        }
        finally{
            try {               
                stmt.close();
                rset.close();
                con.close();
            } catch (SQLException e) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao fechar conexão do banco de dados...");
            }
        }
        return pessoaLida;
    }
    public List<Pessoa> listarPessoasDAO(){
        con = Gerenciador.abirConexao();
        String sql = "SELECT * FROM pessoa";
        PreparedStatement stmt = null;
        ResultSet rset = null;
        Pessoa pessoaLida = null;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            stmt = con.prepareCall(sql);
            
            rset = stmt.executeQuery();
            
            while(rset.next()){
                pessoaLida = new Pessoa();
                pessoaLida.setNome(rset.getString("nome"));
                pessoaLida.setEndereco(rset.getString("endereco"));
                pessoaLida.setCidade(rset.getString("cidade"));
                pessoaLida.setTelefone(rset.getString("telefone"));
                pessoas.add(pessoaLida);
            }
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao recuperar dados");
            pessoaLida = null;
        }
        finally{
            try {               
                stmt.close();
                rset.close();
                con.close();
            } catch (SQLException e) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao fechar conexão do banco de dados...");
            }
        }
        return pessoas;
    }
    
//Método DML - Atualizar Registro do bando de dados
    public boolean updatePessoa(Pessoa pessoa){
        con = Gerenciador.abirConexao();
        String sql = "UPDATE pessa SET nome = ?, endereco = ?, cidade = ?, telefone = ? WHERE nome = ? ";
        PreparedStatement stmt = null;
        boolean retorno = false;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEndereco());
            stmt.setString(3, pessoa.getCidade());
            stmt.setString(4, pessoa.getTelefone());
            stmt.setString(5, pessoa.getNome());
            stmt.executeUpdate();
            retorno = true;
        } catch (SQLException ex) {
        Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao atualizar " + pessoa.getNome() + " no bando de dados...");
        retorno = false;
    }
    finally{
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao finalizar conexão com banco de dados");
        }
    }
    return retorno;                
    }
    
//Método DML - Deletar Registro do bando de dados
    public boolean deletePessoa(Pessoa pessoa){
        boolean retorno = false;
        con = Gerenciador.abirConexao();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM pessoa WHERE nome = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.executeUpdate();
            retorno = true;
        } catch (SQLException ex) {
        Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao deletar " + pessoa.getNome() + " no bando de dados...");
        retorno = false;
    }
    finally{
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "\nErro ao finalizar conexão com banco de dados");
        }
    }
    return retorno;                
    }
}