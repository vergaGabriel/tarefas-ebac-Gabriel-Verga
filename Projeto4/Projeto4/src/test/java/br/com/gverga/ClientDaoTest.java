package br.com.gverga;

import br.com.gverga.dao.ClientDAO;
import br.com.gverga.dao.IClientDAO;
import br.com.gverga.domain.Client;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ClientDaoTest {
	
	private IClientDAO clientDao;
	
	private Random rd;
	
	public ClientDaoTest() {
		this.clientDao = new ClientDAO();
		rd = new Random();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Client> list = clientDao.getAll();
		list.forEach(cli -> {
			try {
				clientDao.delete(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void getClient() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Client client = createClient();
		clientDao.post(client);
		
		Client clientFound = clientDao.getById(client.getId());
		Assert.assertNotNull(clientFound);
		
	}

	@Test
	public void postClient() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Client client = createClient();
		Client clientCreated = clientDao.post(client);
		Assert.assertNotNull(clientCreated);

		Client clientFound = clientDao.getById(clientCreated.getId());
		Assert.assertNotNull(clientFound);
		
		clientDao.delete(client);

		Client clientFound1 = clientDao.getById(clientCreated.getId());
		Assert.assertNull(clientFound1);
	}
	
	@Test
	public void deleteClient() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Client client = createClient();
		Client clientCreated = clientDao.post(client);
		Assert.assertNotNull(clientCreated);
		
		Client clientFound = clientDao.getById(client.getId());
		Assert.assertNotNull(clientFound);
		
		clientDao.delete(client);
		clientFound = clientDao.getById(client.getId());
		Assert.assertNull(clientFound);
	}
	
	@Test
	public void putClient() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Client client = createClient();
		Client clientCreated = clientDao.post(client);
		Assert.assertNotNull(clientCreated);

		Client clientFound = clientDao.getById(client.getId());
		Assert.assertNotNull(clientFound);

		clientFound.setName("Rodrigo Pires");
		clientDao.put(clientFound);

		Client clientUpdated = clientDao.getById(clientFound.getId());
		Assert.assertNotNull(clientUpdated);
		Assert.assertEquals("Rodrigo Pires", clientUpdated.getName());
		
		clientDao.delete(client);
		clientFound = clientDao.getById(clientUpdated.getId());
		Assert.assertNull(clientFound);
	}
	
	@Test
	public void getAll() throws TipoChaveNaoEncontradaException, DAOException {
		Client client = createClient();
		Client clientCreated = clientDao.post(client);
		Assert.assertNotNull(clientCreated);
		
		Client client1 = createClient();
		Client clientCreated1 = clientDao.post(client);
		Assert.assertNotNull(clientCreated1);
		
		Collection<Client> list = clientDao.getAll();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clientDao.delete(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Client> list1 = clientDao.getAll();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private Client createClient() {
		Client client = new Client();
		client.setDocument(rd.nextLong());
		client.setName("Rodrigo");
		client.setCity("São Paulo");
		client.setAddress("End");
		client.setState("SP");
		client.setNumber(10);
		client.setPhone(1199999999L);
		return client;
	}

}
