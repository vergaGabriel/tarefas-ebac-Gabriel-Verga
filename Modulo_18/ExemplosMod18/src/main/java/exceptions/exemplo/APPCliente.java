package exceptions.exemplo;

import java.util.Scanner;

public class APPCliente {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o codigo do cliente");
        Integer codigo = scan.nextInt();

        try {
            ClienteService.consultarCliente(codigo);
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }
}
