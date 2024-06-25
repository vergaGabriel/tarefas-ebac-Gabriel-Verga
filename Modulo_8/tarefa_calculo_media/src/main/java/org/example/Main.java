package org.example;

public class Main {
    public static void main(String[] args) {
        int nota1=9;
        int nota2=6;
        int nota3=7;
        int nota4=10;
        CalculaMedia calculo = new CalculaMedia();

        double media = calculo.calculo(nota1, nota2, nota3, nota4);
        
        System.out.println("Média das nota foi de: " + media);
    }
}