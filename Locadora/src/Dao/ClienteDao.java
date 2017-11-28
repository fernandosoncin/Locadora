
package Dao;

import Model.ClienteM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {    
    
  public void Cadastrar (ClienteM cliente) throws SQLException{
        PreparedStatement pst;
        String sql;     
        sql = "insert into cliente values (?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setString(2, cliente.getNome());
        pst.setString(3, cliente.getRg());
        pst.setString(4, cliente.getCpf());
        pst.setString(5, cliente.getEmail());
        pst.setString(6, cliente.getSenha());   
        pst.execute();
        pst.close();
}
    
   public void Alterar(ClienteM cliente) throws SQLException{
       PreparedStatement pst;
      String sql;  
        
        sql = "update cliente set "
                 + "nome = ?, "
                 + "rg = ?, "
                 + "cpf = ?, "
                 + "email = ?, "
                 + "senha  = ? "
                 + "where id = ?";
        
        pst = Conexao.getInstance().prepareStatement(sql);
        
        pst.setString(1,cliente.getNome() );
        pst.setString(2, cliente.getRg());
        pst.setString(3, cliente.getCpf());
        pst.setString(4, cliente.getEmail());
        pst.setString(5, cliente.getSenha());
       
        pst.setInt(6, cliente.getId());
        pst.execute();
        pst.close();
     }
   
     public List<ClienteM> ListaTodos() throws SQLException{ 
        List<ClienteM> listaTodos;
        listaTodos = new ArrayList<>();

        String sql = "select * from cliente order by nome";
        PreparedStatement pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

    while (rs.next()){
        listaTodos.add(new ClienteM(rs.getInt("id"), 
                                   rs.getString("nome"),
                                   rs.getString("rg"),
                                   rs.getString("cpf"),
                                   rs.getString("email"),
                                   rs.getString("senha")));
                                   
          }
    pst.close();
    return listaTodos;
    }
     
     
      public void Excluir(ClienteM cliente) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from cliente where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, cliente.getId());
        pst.execute();
        pst.close();
    }
     
     
     public ClienteM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
         ClienteM conselheiro = null;
        
        sql = "select * from cliente where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           conselheiro = new ClienteM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("rg"),
                   rs.getString("cpf"),
                   rs.getString("email"),
                   rs.getString("senha"));
                   
        }
        pst.close();
        
        return conselheiro;
    }
     
     public List<ClienteM> buscaFiltroNome (String Nome) throws SQLException{
     PreparedStatement pst;
     String sql;
     
    List<ClienteM> cliente = new ArrayList<ClienteM>();
    ClienteDao ClienteDAO = new ClienteDao();

    String name = "%"+Nome+"%";
    
    sql = "select * from cliente where nome like ? order by nome";
    pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        cliente.add(new ClienteM(
                rs.getInt("id"),
                rs.getString("nome"), 
                rs.getString("rg"), 
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("senha")));
                
        
    }
    pst.close();
    return cliente;   
    }
     
    public List<ClienteM> buscaFiltroId (String Id) throws SQLException{
     PreparedStatement pst;
     String sql;
     
    List<ClienteM> cliente = new ArrayList<ClienteM>();
    ClienteDao ClienteDAO = new ClienteDao();

    String name = "%"+Id+"%";
    
    sql = "select * from cliente where id like ? order by id";
    pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        cliente.add(new ClienteM(
                rs.getInt("id"),
                rs.getString("nome"), 
                rs.getString("rg"), 
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("senha")));
                
        
    }
    pst.close();
    return cliente;   
    }
     
    
}
