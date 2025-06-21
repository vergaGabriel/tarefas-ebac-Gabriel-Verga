package br.com.verga.dao;

import java.util.List;

import br.com.verga.dao.generic.IGenericDAO;
import br.com.verga.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{
	List<Produto> filtrarProdutos(String query);
}
