package br.com.gverga.services;

import br.com.gverga.dao.IClientDAO;
import br.com.gverga.domain.Client;
import br.com.gverga.services.generic.GenericService;

public class ClientService extends GenericService<Client> implements IClientService{

    public ClientService(IClientDAO clientDAO) {
        super(clientDAO);
    }

}
