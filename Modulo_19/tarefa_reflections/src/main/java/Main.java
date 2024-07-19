import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static String value;

    public static void main(String[] args) {
        Tabela tabela = new Tabela();
        tabela.setTabelaAlunos("Tabela de Alunos");

        Field[] fields = tabela.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(TabelaAnnotation.class)) {
                TabelaAnnotation getTabela = field.getAnnotation(TabelaAnnotation.class);

                String nameMethod = getTabela.value();

                try {
                    Method method = tabela.getClass().getMethod(nameMethod);
                    value = (String) method.invoke(tabela);

                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        
        System.out.println(value);
    }
}
