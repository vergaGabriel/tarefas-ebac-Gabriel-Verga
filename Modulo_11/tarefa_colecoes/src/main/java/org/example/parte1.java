package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class parte1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> listaPessoasNome = new ArrayList<String>();

        System.out.println("Informe o nome das pessoas (separado por ','): ");

        String pessoas = scanner.nextLine();
        String[] pessoasSplit = pessoas.split(",");

        Collections.addAll(listaPessoasNome, pessoasSplit);

        System.out.println("Lista com os nomes: " + listaPessoasNome);
    }
}
