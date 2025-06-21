package br.com.verga.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.verga.domain.Persistente;
import br.com.verga.exceptions.DAOException;
import br.com.verga.exceptions.MaisDeUmRegistroException;
import br.com.verga.exceptions.TableException;
import br.com.verga.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente, E extends Serializable> {
	
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(T entity) throws DAOException;

    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> buscarTodos() throws DAOException;

}
