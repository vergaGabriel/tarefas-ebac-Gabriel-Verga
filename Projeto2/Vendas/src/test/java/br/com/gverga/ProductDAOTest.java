package br.com.gverga;

import br.com.gverga.dao.IProductDAO;

import br.com.gverga.dao.ProductDAOMock;
import br.com.gverga.domain.Product;

import br.com.gverga.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductDAOTest {

    private IProductDAO productDAO;

    private Product product;

    public ProductDAOTest() {
        productDAO = new ProductDAOMock();
    }

    @Before
    public void init() {
        product = new Product();
        product.setName("Teste");
        product.setCode(134L);
        product.setValue(BigDecimal.valueOf(12331));
    }

    @Test
    public void saveProduct() throws TipoChaveNaoEncontradaException {
        Boolean returnSave = productDAO.cadastrar(product);

        Assert.assertTrue(returnSave);
    }

    @Test
    public void searchProduct() {
        Product productFound = productDAO.consultar(product.getCode());

        Assert.assertNotNull(productFound);
    }

    @Test
    public void deleteProduct() {
        productDAO.excluir(product.getCode());
    }

    @Test
    public void alterProduct() throws TipoChaveNaoEncontradaException {
        product.setName("TESTE2");
        productDAO.alterar(product);

        Assert.assertEquals("TESTE2", product.getName());
    }
}
