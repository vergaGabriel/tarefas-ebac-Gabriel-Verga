package br.com.gverga.dao.generic.jpa;

import br.com.gverga.dao.Persistente;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.io.Serializable;
import java.util.Collection;

public class GenericDAO <T extends Persistente, E extends Serializable> implements IGenericDAO<T, E>{
    protected EntityManagerFactory entityManagerFactory;

    @Override
    public T post(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public void delete(T entity) throws DAOException {

    }

    @Override
    public T put(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public T getById(E id) throws MaisDeUmRegistroException, TableException, DAOException {
        return null;
    }

    @Override
    public Collection<T> getAll() throws DAOException {
        return null;
    }
}
