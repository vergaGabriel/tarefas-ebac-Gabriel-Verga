package br.com.gverga.dao;

import br.com.gverga.dao.generic.jpa.GenericDAO;
import br.com.gverga.domain.Sale;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

public class SaleExcludeDAO extends GenericDAO<Sale, Long> implements ISaleDAO {
    public SaleExcludeDAO() {
        super(Sale.class);
    }

    @Override
    public void finishSale(Sale sale) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERATION NOT PERMITTED");
    }

    @Override
    public void cancelSale(Sale sale) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERATION NOT PERMITTED");
    }

    @Override
    public Sale getWithCollection(Long id) {
        throw new UnsupportedOperationException("OPERATION NOT PERMITTED");
    }
}
