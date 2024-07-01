package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parte2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> listaHomens = new ArrayList<String>();
        List<String> listaMulheres = new ArrayList<String>();

        System.out.println("Informe o nome e o sexo (M ou F) das pessoas (separando o sexo por '-' e separando os nomes por ','): ");

        String pessoas = scanner.nextLine();
        String[] pessoasSplit = pessoas.split(",");

        for(String pessoa : pessoasSplit){
            String[] info = pessoa.split("-");
            if(info[1].equalsIgnoreCase("M")){
                listaHomens.add(info[0]);
            } else {
                listaMulheres.add(info[0]);
            }
        }

        System.out.println("Grupo com as pessoas do sexo masculino: " + listaHomens);
        System.out.println("Grupo com as pessoas do sexo feminino: " + listaMulheres);
    }
}
