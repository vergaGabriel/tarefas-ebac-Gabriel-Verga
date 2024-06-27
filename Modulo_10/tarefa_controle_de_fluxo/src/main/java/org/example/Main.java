package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nota=0;

        System.out.println("Informe o valor das 4 notas: ");
        for(int i=0; i<4; i++){
            nota += scanner.nextInt();
        }

        double media = (double) nota/4;

        if(media>=7.0){
            System.out.println("Aluno aprovado");
        } else if (media>=5.0){
            System.out.println("Aluno de recuperação");
        } else {
            System.out.println("Aluno reprovado");
        }
    }
}