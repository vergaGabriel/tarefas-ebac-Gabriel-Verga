package br.com.gverga;

import br.com.gverga.dao.ClienteDAO;
import br.com.gverga.dao.IClienteDAO;
import br.com.gverga.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Gabriel");
        Integer qtd = dao.cadastrar(cliente);

        Assert.assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        Assert.assertNotNull(clienteBD);
        Assert.assertNotNull(clienteBD.getId());
        Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        Assert.assertNotNull(qtdDel);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Gabriel");
        Integer qtd = dao.cadastrar(cliente);

        Assert.assertTrue(qtd == 1);

        List<Cliente> clientes = dao.buscarTodos();

        Assert.assertNotNull(clientes);

        for(Cliente cliente1 : clientes) {
            Integer qtdDel = dao.excluir(cliente1);
            Assert.assertNotNull(qtdDel);
        }
    }

    @Test
    public void atualizarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Gabriel");
        Integer qtd = dao.cadastrar(cliente);

        Assert.assertTrue(qtd == 1);

        Cliente clienteNovo = new Cliente();
        clienteNovo.setCodigo("01");
        clienteNovo.setNome("Gabriel Verga");
        Integer qtdAtt = dao.atualizar(clienteNovo);

        Assert.assertNotNull(qtdAtt);

        Cliente clienteBD = dao.consultar(clienteNovo.getCodigo());
        Assert.assertNotNull(clienteBD);
        Assert.assertNotNull(clienteBD.getId());
        Assert.assertEquals(clienteNovo.getCodigo(), clienteBD.getCodigo());
        Assert.assertEquals(clienteNovo.getNome(), clienteBD.getNome());

        Integer qtdExcluir = dao.excluir(clienteNovo);
        Assert.assertNotNull(qtdExcluir);
    }
}
