
package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao implements Serializable {

    private static Conexao conexao = null;
    private static Connection connection;
    private String usuario;
    private String senha;
    private String url;
    
    public Conexao() throws SQLException{
            
        usuario = "equipe2";
        senha = "mSyHt7CTGaTbPOTh";
        url = "34.226.248.240/phpmyadmin/";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e){
        }
        
    }
    
    public static Connection getInstance() throws SQLException{
        
        if(connection == null){
            synchronized (Conexao.class){
                conexao = new Conexao();
            }
        }        
        return connection;
    }
    
    public static void closeInstance() throws SQLException
    {
        if(connection != null){
           connection.close();
        }
    }
    
    
}
