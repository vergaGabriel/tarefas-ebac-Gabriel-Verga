package br.com.gverga;

import br.com.gverga.dao.IProductDAO;
import br.com.gverga.dao.ProductDAO;

import br.com.gverga.domain.Product;

import br.com.gverga.exception.TipoChaveNaoEncontradaException;
import br.com.gverga.services.IProductService;
import br.com.gverga.services.ProductService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductServiceTest {
    private IProductService productService;

    private Product product;

    public ProductServiceTest() {
        IProductDAO dao = new ProductDAO();
        productService = new ProductService(dao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        product = new Product();
        product.setName("Teste");
        product.setCode(123L);
        product.setValue(BigDecimal.valueOf(12331));

        productService.salvar(product);
    }

    @Test
    public void searchProduct() {
        Product productFound = productService.buscarPorCodigo(product.getCode());

        Assert.assertNotNull(productFound);
    }

    @Test
    public void saveProduct() throws TipoChaveNaoEncontradaException {
        product.setCode(143L);
        Boolean productReturn = productService.salvar(product);
        Assert.assertTrue(productReturn);
    }

    @Test
    public void deleteProduct() {
        productService.excluir(product.getCode());
    }

    @Test
    public void alterProduct() throws TipoChaveNaoEncontradaException {
        product.setName("teste2");
        productService.alterar(product);

        Assert.assertEquals("teste2", product.getName());
    }
}
