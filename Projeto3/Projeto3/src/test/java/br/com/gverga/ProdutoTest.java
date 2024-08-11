package br.com.gverga;

import br.com.gverga.dao.IProdutoDAO;
import br.com.gverga.dao.ProdutoDAO;
import br.com.gverga.domain.Cliente;
import br.com.gverga.domain.Produto;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Pao");
        produto.setValor(12.6);
        Integer qtd = dao.cadastrar(produto);

        Assert.assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produto.getValor(), produtoBD.getValor());

        Integer qtdExcluir = dao.excluir(produto);
        Assert.assertNotNull(qtdExcluir);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Pao");
        produto.setValor(12.6);
        Integer qtd = dao.cadastrar(produto);

        Assert.assertTrue(qtd == 1);

        List<Produto> produtos = dao.buscarTodos();

        Assert.assertNotNull(produtos);

        for (Produto produto1 : produtos) {
            Integer qtdDel = dao.excluir(produto1);
            Assert.assertNotNull(qtdDel);
        }
    }

    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produtoAntigo = new Produto();
        produtoAntigo.setCodigo("01");
        produtoAntigo.setNome("Pao");
        produtoAntigo.setValor(12.6);
        Integer qtd = dao.cadastrar(produtoAntigo);

        Assert.assertTrue(qtd == 1);

        Produto produtoNovo = new Produto();
        produtoNovo.setCodigo("01");
        produtoNovo.setNome("Pao");
        produtoNovo.setValor(14.7);
        Integer qtdAtt = dao.atualizar(produtoNovo);

        Assert.assertNotNull(qtdAtt);

        Produto produtoBD = dao.consultar(produtoNovo.getCodigo());
        Assert.assertNotNull(produtoBD);
        Assert.assertNotNull(produtoBD.getId());
        Assert.assertEquals(produtoNovo.getCodigo(), produtoBD.getCodigo());
        Assert.assertEquals(produtoNovo.getNome(), produtoBD.getNome());

        Integer qtdExcluir = dao.excluir(produtoNovo);
        Assert.assertNotNull(qtdExcluir);
    }
}
