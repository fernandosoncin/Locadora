
package Dao;

import Model.LocaçãoM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LocaçaoDao {
    
        public void Salvar (LocaçãoM locacao) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into locacao values (?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setInt(2, locacao.getId_cliente().getId());
        pst.setInt(3, locacao.getId_filme().getId());
        pst.setString(4, locacao.getData_locacao());
        pst.setString(5, locacao.getData_entrega());
        
        pst.execute();
        pst.close();
        
        }
        
        public void Excluir(LocaçãoM locacao) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from locacao where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, locacao.getId());
        pst.execute();
        pst.close();
    }       
        
        
        public void Alterar(LocaçãoM locacao) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update locacao set "                 
                 + "cliente_id = ?, "
                 + "filme_id = ?, "
                 + "data_locacao = ?, "  
                 + "data_entrega = ? "                 
                
                 + "where id = ?";
        
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, locacao.getId_cliente().getId());
        pst.setInt(2, locacao.getId_filme().getId());
        pst.setString(3, locacao.getData_locacao());
        pst.setString(4, locacao.getData_entrega()); 
        
        pst.setInt(5, locacao.getId());
        pst.execute();
        pst.close();
     }
        
             public List<LocaçãoM> ListaTodos() throws SQLException{ 
    List<LocaçãoM> listaTodos = new ArrayList<>();

        String sql = "select * from locacao order by id desc";
        PreparedStatement pst = Conexao.getInstance().prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    while (rs.next()){
        listaTodos.add(new LocaçãoM(rs.getInt("id"), 
                                   ClienteDao.busca(rs.getInt("cliente_id")),
                                   FilmeDao.busca(rs.getInt("filme_id")),
                                   rs.getString("data_locacao"),
                                   rs.getString("data_entrega")));
                                  
          }
    pst.close();
    return listaTodos;
    }
             
       public LocaçãoM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
        LocaçãoM locaçao = null;
        
        sql = "select * from locacao where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           locaçao = new LocaçãoM(
                   rs.getInt("id"),
                   ClienteDao.busca(rs.getInt("cliente_id")),
                   FilmeDao.busca(rs.getInt("filme_id")),
                   rs.getString("data_locacao"),
                   rs.getString("data_entrega"));
                   
        }
        pst.close();
        
        return locaçao;
    }
    
}
