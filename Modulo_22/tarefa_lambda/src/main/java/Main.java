import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome e o sexo (M ou F) das pessoas (separando o sexo por '-' e separando os nomes por ','): ");

        String pessoas = scanner.nextLine();
        List<String> pessoasSplit = Arrays.asList(pessoas.split(","));

        List<String> listaMulheres = pessoasSplit.stream()
                .filter(n -> n.endsWith("F"))
                .map(n -> {
                    return n.substring(0, n.length()-2);
                })
                .collect(Collectors.toList());

        System.out.println(listaMulheres);
    }
}