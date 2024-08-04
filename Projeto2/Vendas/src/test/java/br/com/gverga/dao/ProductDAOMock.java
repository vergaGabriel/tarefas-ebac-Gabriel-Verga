package br.com.gverga.dao;

import br.com.gverga.domain.Client;
import br.com.gverga.domain.Product;
import br.com.gverga.exception.TipoChaveNaoEncontradaException;

public class ProductDAOMock implements IProductDAO{
    @Override
    public Boolean cadastrar(Product entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Product entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Product consultar(Long valor) {
        Product product = new Product();
        product.setCode(valor);
        return product;
    }
}
