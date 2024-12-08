package br.com.gverga;

import br.com.gverga.dao.IProductDAO;
import br.com.gverga.dao.ProductDAO;
import br.com.gverga.domain.Product;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProductDAOTest {

	private IProductDAO productDao;
	
	public ProductDAOTest() {
		this.productDao = new ProductDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Product> list = productDao.getAll();
		list.forEach(cli -> {
			try {
				productDao.delete(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void search() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		Product product = createProduct("A1");
		Assert.assertNotNull(product);
		Product productDB = this.productDao.getById(product.getId());
		Assert.assertNotNull(productDB);
	}
	
	@Test
	public void post() throws TipoChaveNaoEncontradaException, DAOException {
		Product product = createProduct("A2");
		Assert.assertNotNull(product);
	}
	
	@Test
	public void delete() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Product product = createProduct("A3");
		Assert.assertNotNull(product);
		this.productDao.delete(product);
		Product productDB = this.productDao.getById(product.getId());
		assertNull(productDB);
	}
	
	@Test
	public void createClient() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Product product = createProduct("A4");
		product.setName("Rodrigo Pires");
		productDao.put(product);
		Product productDB = this.productDao.getById(product.getId());
		assertNotNull(productDB);
		Assert.assertEquals("Rodrigo Pires", productDB.getName());
	}
	
	@Test
	public void getAll() throws DAOException, TipoChaveNaoEncontradaException {
		createProduct("A5");
		createProduct("A6");
		Collection<Product> list = productDao.getAll();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (Product prod : list) {
			this.productDao.delete(prod);
		}
		
		list = productDao.getAll();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}
	
	private Product createProduct(String code) throws TipoChaveNaoEncontradaException, DAOException {
		Product product = new Product();
		product.setCode(code);
		product.setDescription("Produto 1");
		product.setName("Produto 1");
		product.setValue(BigDecimal.TEN);
		productDao.post(product);
		return product;
	}
}
