package br.com.gverga;

import br.com.gverga.dao.ContratoDao;
import br.com.gverga.dao.IContratoDao;
import br.com.gverga.dao.mock.ContratoDaoMock;
import br.com.gverga.service.ContratoService;
import br.com.gverga.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();

        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDaoMock();

        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDaoMock();

        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDaoMock();

        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoDeDados() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();

        Assert.assertEquals("Sucesso", retorno);
    }
}
