package br.com.gverga.testes;

import br.com.gverga.TesteCliente;
import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTestCase {
    @Test
    public void testeCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Gabriel");

        Assert.assertEquals("Gabriel", cli.getNome());
    }
}
