package br.com.gverga.cadastro.domain;

public class Produto implements Persistente{

    private Long codigo;
    private String nome;
    private Integer preco;

    public Produto(String nome, String codigo, String preco) {
        this.nome = nome;
        this.codigo = Long.valueOf(codigo.trim());
        this.preco = Integer.valueOf(preco.trim());
    }

    @Override
    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }
}
