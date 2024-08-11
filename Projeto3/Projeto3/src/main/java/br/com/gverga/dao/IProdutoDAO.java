package br.com.gverga.dao;

import br.com.gverga.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws Exception;

    Produto consultar(String codigo) throws Exception;

    Integer excluir(Produto produto) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Integer atualizar(Produto produtoNovo) throws Exception;
}
