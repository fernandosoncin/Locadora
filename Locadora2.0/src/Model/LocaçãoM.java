
package Model;


public class LocaçãoM {
    
    private int id;
    private ClienteM id_cliente;
    private FilmeM id_filme;
    private String data_locacao;
    private String data_entrega;

    public LocaçãoM(int id, ClienteM id_cliente, FilmeM id_filme, String data_locacao, String data_entrega) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_filme = id_filme;
        this.data_locacao = data_locacao;
        this.data_entrega = data_entrega;
    }

    public LocaçãoM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteM getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(ClienteM id_cliente) {
        this.id_cliente = id_cliente;
    }

    public FilmeM getId_filme() {
        return id_filme;
    }

    public void setId_filme(FilmeM id_filme) {
        this.id_filme = id_filme;
    }

    public String getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }
    
    
}
