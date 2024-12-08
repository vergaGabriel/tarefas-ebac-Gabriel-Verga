package br.com.gverga.dao;

import br.com.gverga.dao.generic.jpa.GenericDAO;
import br.com.gverga.domain.Client;

public class ClientDAO extends GenericDAO<Client, Long> implements IClientDAO {
    public ClientDAO() {
        super(Client.class);
    }
}
