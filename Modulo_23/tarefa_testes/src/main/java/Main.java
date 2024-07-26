import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    @Test
    public void teste(){
        List<String> pessoas = new ArrayList<>();
        pessoas.add("Julia-F");
        pessoas.add("Juliana-F");
        pessoas.add("Fernando-M");
        pessoas.add("Roberta-F");
        pessoas.add("Marcos-M");

        List<String> listaMulheres = pessoas.stream()
                .filter(n -> n.endsWith("F"))
                .collect(Collectors.toList());

        listaMulheres.forEach(n -> Assert.assertEquals("F", String.valueOf(n.charAt(n.length() - 1))));
    }
}