package br.com.gverga.dao;

import br.com.gverga.dao.generic.GenericDAO;
import br.com.gverga.domain.Product;

public class ProductDAO extends GenericDAO<Product> implements IProductDAO{

    public ProductDAO() {
        super();
    }

    @Override
    public Class<Product> getTipoClasse() {
        return Product.class;
    }

    @Override
    public void atualiarDados(Product entity, Product entityCadastrado) {

    }
//    @Override
//    public Boolean save(Product product) {
//        return null;
//    }
//
//    @Override
//    public Product search(String code) {
//        return null;
//    }
//
//    @Override
//    public void delete(String code) {
//
//    }
//
//    @Override
//    public void alter(Product product) {
//
//    }
}
