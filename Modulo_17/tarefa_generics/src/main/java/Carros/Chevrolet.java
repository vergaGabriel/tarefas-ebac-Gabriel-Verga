package Carros;

public abstract class Chevrolet implements Carro{
    private int ano;
    private String cor;
    private int cavalos;

    public Chevrolet(int ano, String cor, int cavalos) {
        this.ano = ano;
        this.cor = cor;
        this.cavalos = cavalos;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public int getCavalos() {
        return cavalos;
    }
}
