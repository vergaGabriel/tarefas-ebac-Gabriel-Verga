package br.com.gverga.services;

import br.com.gverga.dao.IClienteDAO;
import br.com.gverga.domain.Cliente;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
