package br.com.gverga.dao;

import br.com.gverga.dao.generic.jpa.GenericDAO;
import br.com.gverga.domain.Client;
import br.com.gverga.domain.Product;
import br.com.gverga.domain.Sale;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SaleDAO extends GenericDAO<Sale, Long> implements ISaleDAO {

    public SaleDAO() {
        super(Sale.class);
    }

    @Override
    public void finishSale(Sale sale) throws TipoChaveNaoEncontradaException, DAOException {
        super.put(sale);
    }

    @Override
    public void cancelSale(Sale sale) throws TipoChaveNaoEncontradaException, DAOException {
        super.put(sale);
    }

    @Override
    public void delete(Sale entity) throws DAOException {
        throw new UnsupportedOperationException("OPERATION NOT PERMITTED");
    }

    @Override
    public Sale post(Sale entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            openConnection();
            entity.getProducts().forEach(prod -> {
                Product product = entityManager.merge(prod.getProduct());
                prod.setProduct(product);
            });
            Client client = entityManager.merge(entity.getClient());
            entity.setClient(client);
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        } catch (Exception e) {
            throw new DAOException("ERROR SAVING SALE", e);
        }
    }

    @Override
    public Sale getWithCollection(Long id) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sale> query = builder.createQuery(Sale.class);
        Root<Sale> root = query.from(Sale.class);
        root.fetch("client");
        root.fetch("products");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Sale> tpQuery =
                entityManager.createQuery(query);
        Sale sale = tpQuery.getSingleResult();
        closeConnection();
        return sale;
    }
}
