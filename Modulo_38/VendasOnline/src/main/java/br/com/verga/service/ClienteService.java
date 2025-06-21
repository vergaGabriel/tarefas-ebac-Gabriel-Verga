package br.com.verga.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.verga.dao.IClienteDAO;
import br.com.verga.domain.Cliente;
import br.com.verga.exceptions.DAOException;
import br.com.verga.exceptions.MaisDeUmRegistroException;
import br.com.verga.exceptions.TableException;
import br.com.verga.services.generic.GenericService;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
