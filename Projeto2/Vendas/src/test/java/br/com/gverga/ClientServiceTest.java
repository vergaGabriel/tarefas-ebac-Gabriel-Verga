package br.com.gverga;

import br.com.gverga.dao.ClientDAO;
import br.com.gverga.dao.ClientDAOMock;
import br.com.gverga.dao.IClientDAO;
import br.com.gverga.domain.Client;
import br.com.gverga.exception.TipoChaveNaoEncontradaException;
import br.com.gverga.services.ClientService;
import br.com.gverga.services.IClientService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientServiceTest {

    private IClientService clienteService;

    private Client cliente;

    public ClientServiceTest() {
        IClientDAO dao = new ClientDAO();
        clienteService = new ClientService(dao);
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
        clienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Client clienteConsultado = clienteService.buscarPorCodigo(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setCpf(1245L);
        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Gabriel Verga");
        clienteService.alterar(cliente);

        Assert.assertEquals("Gabriel Verga", cliente.getNome());
    }
}
