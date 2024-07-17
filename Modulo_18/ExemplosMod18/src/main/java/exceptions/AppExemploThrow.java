package exceptions;

public class AppExemploThrow {

    public static void main(String[] args) {
        exception();
        runtimeException();
    }

    public static void runtimeException() {
        ExemploThrow.saqueRuntimeException(500);
    }

    private static void exception() {
        try {
            ExemploThrow.saque(500);
        } catch (LimiteSaqueException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
