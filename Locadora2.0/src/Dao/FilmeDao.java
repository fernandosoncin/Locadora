/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ClienteM;
import Model.FilmeM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class FilmeDao {
    public void Cadastrar (FilmeM filme) throws SQLException{
        PreparedStatement pst;
        String sql;     
        sql = "insert into filme values (?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setString(2, filme.getTitulo());
        pst.setString(3, filme.getGenero());
        pst.setString(4, filme.getAno());
        pst.setString(5, filme.getEstrelando());
        pst.setString(6, filme.getClassificacao());
        pst.setString(7, filme.getDirecao());
        pst.setString(8, filme.getDuracao());       
        pst.setString(9, filme.getSinopse());
        pst.execute();
        pst.close();
}
 
       public void Alterar(FilmeM filme) throws SQLException{
       PreparedStatement pst;
      String sql;  
        
        sql = "update filme set "
                 + "titulo = ?, "
                 + "genero = ?, "
                 + "ano = ?, "
                 + "estrelando  = ?, "
                 + "classificacao  = ?, "
                 + "direcao  = ?, "
                 + "duracao  = ?, "
                 + "sinopse = ? "
                 + "where id = ?";
        
        pst = Conexao.getInstance().prepareStatement(sql);
        
        pst.setString(1, filme.getTitulo() );
        pst.setString(2, filme.getGenero());
        pst.setString(3, filme.getAno());
        pst.setString(4, filme.getEstrelando());
        pst.setString(5, filme.getClassificacao());
        pst.setString(6, filme.getDirecao());
        pst.setString(7, filme.getDuracao());
        pst.setString(8, filme.getSinopse());
               
        pst.setInt(9, filme.getId());
        pst.execute();
        pst.close();
     }
   
    public List<FilmeM> ListaTodos() throws SQLException{ 
        List<FilmeM> listaTodos;
        listaTodos = new ArrayList<>();

        String sql = "select * from filme order by titulo";
        PreparedStatement pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
        listaTodos.add(new FilmeM(rs.getInt("id"), 
                                   rs.getString("titulo"),
                                   rs.getString("genero"),
                                   rs.getString("ano"),
                                   rs.getString("estrelando"),
                                   rs.getString("classificacao"),
                                   rs.getString("direcao"),
                                   rs.getString("duracao"),                          
                                   rs.getString("sinopse")));
                                   
          }
        pst.close();
        return listaTodos;
}
    
     public void Excluir(FilmeM filme) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from filme where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, filme.getId());
        pst.execute();
        pst.close();
    }
     
    static public FilmeM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
            FilmeM filme = null;
        
        sql = "select * from filme where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           filme = new FilmeM(
                   rs.getInt("id"),
                   rs.getString("titulo"),
                   rs.getString("genero"),
                   rs.getString("ano"),
                    rs.getString("estrelando"),
                   rs.getString("classificacao"),       
                    rs.getString("direcao"),
                    rs.getString("duracao"),    
                   rs.getString("sinopse"));
                   
        }
        pst.close();
        
        return filme;
    }
         
    public List<FilmeM> buscaFiltroNome (String Titulo) throws SQLException{
     PreparedStatement pst;
     String sql;
     
    List<FilmeM> filme = new ArrayList<FilmeM>();
    FilmeDao filmeDao = new FilmeDao();

    String name = "%"+Titulo+"%";
    
    sql = "select * from filme where titulo like ? order by titulo";
    pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        filme.add(new FilmeM(
                   rs.getInt("id"),
                   rs.getString("titulo"),
                   rs.getString("genero"),
                   rs.getString("ano"),
                   rs.getString("estrelando"),
                   rs.getString("classificacao"),       
                   rs.getString("direcao"),
                   rs.getString("duracao"),    
                   rs.getString("sinopse")));
                
        
    }
    pst.close();
    return filme;   
    }
    
    public List<FilmeM> buscaFiltroId (String Id) throws SQLException{
     PreparedStatement pst;
     String sql;
     
    List<FilmeM> filme = new ArrayList<FilmeM>();
    FilmeDao filmeDao = new FilmeDao();

    String name = "%"+Id+"%";
    
    sql = "select * from filme where id like ? order by id";
    pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        filme.add(new FilmeM(
                   rs.getInt("id"),
                   rs.getString("titulo"),
                   rs.getString("genero"),
                   rs.getString("ano"),
                   rs.getString("estrelando"),
                   rs.getString("classificacao"),       
                   rs.getString("direcao"),
                   rs.getString("duracao"),    
                   rs.getString("sinopse")));
                
        
    }
    pst.close();
    return filme;   
    }
}
