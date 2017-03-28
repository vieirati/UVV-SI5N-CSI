/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vieira
 */
public class Gerenciador {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/bancojsfinserirbuscar";
    private static final String USER = "root";
    private static final String PASSWORD = "jJcf@1106";
    public static final String FALHA_INSERCAO = "falhaInsercao";
    public static final String SUCESSO_INSERCAO = "feedInsercao";
    public static final String BUSCA_VALIDA = "feedBusca";
    public static final String BUSCA_INVALIDA = "falhaBusca";
    
    public static final String FALHA_UPDATE = "";
    public static final String SUCESSO_UPDATE = "";
    public static final String FALHA_DELETE = "";
    public static final String SUCESSO_DELETE = "";
    
    public static Connection abirConexao(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }
}
