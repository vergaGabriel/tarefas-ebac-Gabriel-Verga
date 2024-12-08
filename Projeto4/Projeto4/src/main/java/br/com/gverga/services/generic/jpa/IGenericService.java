package br.com.gverga.services.generic.jpa;

import br.com.gverga.dao.Persistente;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {
    public T post(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void delete(T entity) throws DAOException;

    public T put(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T getByValue(E value) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> getAll() throws DAOException;
}
