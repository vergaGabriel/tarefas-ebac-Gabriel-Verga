package org.example;

/**
 *
 * @author gabriel.verga
 */
public class Conta {
    private int saldo;
    private String cliente;
    private String numeroConta;

    public int getSaldo() {
        return saldo;
    }

    /**
     * Método para depositar valor
     *
     * @param valor, valor a ser depositado na conta
     */
    public void depositaSaldo(int valor){
        this.saldo+=valor;
    }

    /**
     * Método para sacar valor
     *
     * @param valor, valor a ser sacado da conta
     */
    public void sacarSaldo(int valor){
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente!");
            System.out.println("Saldo total disponivel: " + this.saldo);
        } else {
            this.saldo-=valor;
        }
    }
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    /**
     * Método para exibir todas as informações da conta
     */
    public void imprimeInformacoes() {
        System.out.println("Saldo Disponivel: " + getSaldo() +
                           "\nNumero da Conta: " + getNumeroConta()+
                           "\nNome do Cliente: " + getCliente() + "\n");
    }
}
