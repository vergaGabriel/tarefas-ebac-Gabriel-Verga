package org.example;

/**
 *
 * @author gabriel.verga
 */
public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.setNumeroConta("5345345");
        conta1.setCliente("Gabriel");
        conta1.depositaSaldo(350);

        conta1.imprimeInformacoes();

        conta1.sacarSaldo(70);

        conta1.imprimeInformacoes();

        conta1.sacarSaldo(400);
    }
}