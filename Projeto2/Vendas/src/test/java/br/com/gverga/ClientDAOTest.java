package br.com.gverga;

import br.com.gverga.dao.ClientDAO;
import br.com.gverga.dao.ClientDAOMock;
import br.com.gverga.dao.IClientDAO;

import br.com.gverga.domain.Client;

import br.com.gverga.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientDAOTest {

    private IClientDAO clienteDao;

    private Client cliente;

    public ClientDAOTest() {
        clienteDao = new ClientDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Client();
        cliente.setCpf(123123123L);
        cliente.setNome("Gabriel");
        cliente.setCidade("Sao paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1143423424L);
        clienteDao.cadastrar(cliente);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setCpf(56565656565L);
        Boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente() {
        Client clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Gabriel Verga");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Gabriel Verga", cliente.getNome());
    }

}
