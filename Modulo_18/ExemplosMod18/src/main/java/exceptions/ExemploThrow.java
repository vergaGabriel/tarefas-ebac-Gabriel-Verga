package exceptions;

public class ExemploThrow {

    public static void saque(double valor) throws LimiteSaqueException {
        if (valor > 400) {
            LimiteSaqueException erro =
                    new LimiteSaqueException("Valor solicitado é maior que seu limite diario.");
            throw erro;
        } else {
            System.out.println("Valor retirado da conta: R$"+valor);
        }
    }

    public static void saqueRuntimeException(double valor) {
        if (valor > 400) {
            IllegalArgumentException erro =
                    new IllegalArgumentException("Valor solicitado é maior que seu limite diario.");
            throw erro;
        } else {
            System.out.println("Valor retirado da conta: R$"+valor);
        }
    }
}
