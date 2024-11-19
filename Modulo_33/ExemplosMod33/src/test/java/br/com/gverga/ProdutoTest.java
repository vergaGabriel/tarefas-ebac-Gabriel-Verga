package br.com.gverga;

import br.com.gverga.dao.IProdutoDao;
import br.com.gverga.dao.ProdutoDao;
import br.com.gverga.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {
    private IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setPreco(200D);
        produto.setNome("Curso de Java Backend");
        produto = produtoDao.cadastrar(produto);

        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getId());
    }
}
