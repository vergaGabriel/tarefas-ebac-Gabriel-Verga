package br.com.gverga.services;

import br.com.gverga.domain.Cliente;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
}
