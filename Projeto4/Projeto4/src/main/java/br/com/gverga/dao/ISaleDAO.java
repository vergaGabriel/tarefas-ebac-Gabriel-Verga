package br.com.gverga.dao;

import br.com.gverga.dao.generic.jpa.IGenericDAO;
import br.com.gverga.domain.Sale;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

public interface ISaleDAO extends IGenericDAO<Sale, Long> {
    public void finishSale(Sale sale) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelSale(Sale sale) throws TipoChaveNaoEncontradaException, DAOException;

    public Sale getWithCollection(Long id);
}
