package exceptions.exemplo;

public class ClienteService {
    public static void consultarCliente(Integer codigo) throws ClienteNaoEncontradoException{
        boolean isCadastrado = false;

        if (!isCadastrado) {
            throw new ClienteNaoEncontradoException("Cliente nao foi encontrado");
        }
    }
}
