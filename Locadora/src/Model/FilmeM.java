
package Model;

public class FilmeM {
    
    private int id;
    private String titulo;
    private String genero;
    private String ano;
    private String classificacao;
    private String duracao;
    private String direcao;
    private String estrelando;
    private String sinopse;

    public FilmeM(int id, String titulo, String genero, String ano, String classificacao, String duracao, String direcao, String estrelando, String sinopse) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.classificacao = classificacao;
        this.duracao = duracao;
        this.direcao = direcao;
        this.estrelando = estrelando;
        this.sinopse = sinopse;
    }

    public FilmeM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getEstrelando() {
        return estrelando;
    }

    public void setEstrelando(String estrelando) {
        this.estrelando = estrelando;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    
}
