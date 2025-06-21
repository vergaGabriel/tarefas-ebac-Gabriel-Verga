package br.com.verga.service;

import java.util.List;

import br.com.verga.domain.Produto;
import br.com.verga.services.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
