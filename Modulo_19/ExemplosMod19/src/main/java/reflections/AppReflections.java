package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppReflections {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Produto.class;
        System.out.println(clazz.getSimpleName());

        System.out.println(Produto.class.getSimpleName());

        Constructor con = clazz.getConstructor();
        System.out.println(con);

        Produto prod = (Produto) con.newInstance();

        Field[] fields = prod.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getSimpleName());
        }

        Method[] methods = prod.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType().getSimpleName());
        }
        Method method = prod.getClass().getDeclaredMethod("setCodigo", Long.class);
        Method method1 = prod.getClass().getDeclaredMethod("getCodigo");

        method.invoke(prod, 10L);
        System.out.println(method1.invoke(prod));

    }
}
