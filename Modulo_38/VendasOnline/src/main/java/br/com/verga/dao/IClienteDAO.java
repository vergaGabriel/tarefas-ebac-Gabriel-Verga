package br.com.verga.dao;

import java.util.List;

import br.com.verga.dao.generic.IGenericDAO;
import br.com.verga.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long>{
	List<Cliente> filtrarClientes(String query);
}
