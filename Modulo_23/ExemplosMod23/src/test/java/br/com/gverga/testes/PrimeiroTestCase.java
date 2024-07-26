package br.com.gverga.testes;

import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTestCase {
    @Test
    public void test() {
        String nome = "Gabriel";
        Assert.assertEquals("Gabriel", nome);
    }

    @Test
    public void testNotEquals() {
        String nome = "Gabriel";
        Assert.assertNotEquals("Gabriel1", nome);
    }
}
