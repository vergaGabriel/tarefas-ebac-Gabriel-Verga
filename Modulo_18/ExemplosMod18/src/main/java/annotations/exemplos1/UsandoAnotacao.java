package annotations.exemplos1;

import java.lang.annotation.RetentionPolicy;

@ExemploAnotacao(value = 1, nomes={"Gabriel"},
        value2 = {RetentionPolicy.RUNTIME},
        value3 = RetentionPolicy.RUNTIME)
public class UsandoAnotacao {

    private String nome;

}
