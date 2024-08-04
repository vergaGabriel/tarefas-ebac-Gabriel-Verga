package br.com.gverga.dao;

import br.com.gverga.dao.generic.GenericDAO;
import br.com.gverga.domain.Client;
import br.com.gverga.domain.Product;

public class ClientDAO extends GenericDAO<Client> implements IClientDAO {

    public ClientDAO() {
        super();
    }

    @Override
    public Class<Client> getTipoClasse() {
        return Client.class;
    }

    @Override
    public void atualiarDados(Client entity, Client entityCadastrado) {

    }
}
