package br.com.gverga.dao;

import br.com.gverga.domain.Client;
import br.com.gverga.exception.TipoChaveNaoEncontradaException;


public class ClientDAOMock implements IClientDAO {

    @Override
    public Boolean cadastrar(Client entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Client entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Client consultar(Long valor) {
        Client cliente = new Client();
        cliente.setCpf(valor);
        return cliente;
    }

}
