package br.com.verga.dao;

import br.com.verga.dao.generic.IGenericDAO;
import br.com.verga.domain.Venda;
import br.com.verga.exceptions.DAOException;
import br.com.verga.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long>{

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public Venda consultarComCollection(Long id);

}
