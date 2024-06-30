package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parte2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> listaPessoasNome = new ArrayList<String>();
        List<String> listaPessoasSexo = new ArrayList<String>();

        System.out.println("Informe o nome e o sexo das pessoas (separando o sexo por '-' e separando os nomes por ','): ");

        String pessoas = scanner.nextLine();
        String[] pessoasSplit = pessoas.split(",");

        for(String pessoa : pessoasSplit){
            String[] info = pessoa.split("-");
            listaPessoasNome.add(info[0]);
            listaPessoasSexo.add(info[1]);
        }

        System.out.println("Grupo com os nomes: " + listaPessoasNome);
        System.out.println("Grupo com os sexos: " + listaPessoasSexo);
    }
}
