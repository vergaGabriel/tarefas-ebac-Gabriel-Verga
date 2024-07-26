package br.com.gverga.testes;

import org.junit.Assert;
import org.junit.Test;

public class SegundoTestCase {
    @Test
    public void test() {
        String nome = "Gabriel";
        Assert.assertEquals("Gabriel", nome);
    }
}
