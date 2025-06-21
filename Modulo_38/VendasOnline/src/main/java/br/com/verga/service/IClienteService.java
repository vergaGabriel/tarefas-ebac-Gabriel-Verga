package br.com.verga.service;

import java.util.List;

import br.com.verga.domain.Cliente;
import br.com.verga.exceptions.DAOException;
import br.com.verga.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
