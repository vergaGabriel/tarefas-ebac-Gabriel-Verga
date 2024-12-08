package br.com.gverga.dao;

import br.com.gverga.dao.generic.jpa.GenericDAO;
import br.com.gverga.domain.Product;

public class ProductDAO extends GenericDAO<Product, Long> implements IProductDAO {
    public ProductDAO() {
        super(Product.class);
    }
}
