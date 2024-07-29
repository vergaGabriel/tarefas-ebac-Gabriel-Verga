package br.com.gverga.dao;

public class ClienteDaoMock implements IClienteDao{

    @Override
    public String salvar() {
        return "Sucesso";
    }
}
