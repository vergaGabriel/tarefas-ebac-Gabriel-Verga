package annotations.exemplos1;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface ExemploAnotacao {

    long value();
    String[] nomes();
    RetentionPolicy[] value2();
    RetentionPolicy value3();
    String nomeDefault() default "Gabriel";
}
