/**
 * 
 */
package br.com.gverga.services;

import br.com.gverga.domain.Cliente;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
