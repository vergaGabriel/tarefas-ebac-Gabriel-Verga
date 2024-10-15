/**
 * 
 */
package br.com.gverga.dao;

import br.com.gverga.dao.generic.IGenericDAO;
import br.com.gverga.domain.Venda;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
