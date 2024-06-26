package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um valor");
        int valorP = scanner.nextInt();

        Integer valorW = valorP;
        System.out.println("Valor convertido para a sua classe Wrapper: " + valorW);

    }
}