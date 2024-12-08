package br.com.gverga.services.generic.jpa;

import br.com.gverga.dao.Persistente;
import br.com.gverga.dao.generic.jpa.IGenericDAO;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public class GenericService <T extends Persistente, E extends Serializable> implements IGenericService<T, E>{
    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T post(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.post(entity);
    }

    @Override
    public void delete(T entity) throws DAOException {
        this.dao.delete(entity);
    }

    @Override
    public T put(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.put(entity);
    }

    @Override
    public T getByValue(E value) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.getById(value);
    }

    @Override
    public Collection<T> getAll() throws DAOException {
        return this.dao.getAll();
    }
}
