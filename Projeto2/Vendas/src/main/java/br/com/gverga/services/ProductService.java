package br.com.gverga.services;

import br.com.gverga.dao.IProductDAO;
import br.com.gverga.domain.Product;
import br.com.gverga.exception.TipoChaveNaoEncontradaException;
import br.com.gverga.services.generic.GenericService;

public class ProductService extends GenericService<Product> implements IProductService {
    public ProductService(IProductDAO dao) {
        super(dao);
    }

}
