/**
 * 
 */
package br.com.gverga;

import br.com.gverga.dao.SaleExcludeDAO;
import br.com.gverga.dao.*;
import br.com.gverga.domain.Client;
import br.com.gverga.domain.Product;
import br.com.gverga.domain.Sale;
import br.com.gverga.domain.Sale.Status;
import br.com.gverga.exceptions.DAOException;
import br.com.gverga.exceptions.MaisDeUmRegistroException;
import br.com.gverga.exceptions.TableException;
import br.com.gverga.exceptions.TipoChaveNaoEncontradaException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class SaleDAOTest {
	
	private ISaleDAO saleDao;
	
	private ISaleDAO saleExcludeDao;

	private IClientDAO clientDao;
	
	private IProductDAO productDao;
	
	private Random rd;
	
	private Client client;
	
	private Product product;
	
	public SaleDAOTest() {
		this.saleDao = new SaleDAO();
		saleExcludeDao = new SaleExcludeDAO();
		this.clientDao = new ClientDAO();
		this.productDao = new ProductDAO();
		rd = new Random();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.client = createClient();
		this.product = createProduct("A1", BigDecimal.TEN);
	}
	
	@After
	public void end() throws DAOException {
		deleteSale();
		deleteProducts();
		clientDao.delete(this.client);
	}
	
	@Test
	public void search() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Sale sale = createSale("A1");
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		Sale saleFound = saleDao.getById(sale.getId());
		assertNotNull(saleFound);
		assertEquals(sale.getCode(), saleFound.getCode());
	}
	
	@Test
	public void post() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Sale sale = createSale("A2");
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		
		assertTrue(sale.getTotalValue().equals(BigDecimal.valueOf(20)));
		assertTrue(sale.getStatus().equals(Status.STARTED));
		
		Sale saleFound = saleDao.getById(sale.getId());
		assertTrue(saleFound.getId() != null);
		assertEquals(sale.getCode(), saleFound.getCode());
	} 
	
	@Test
	public void cancelSale() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A3";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		postReturn.setStatus(Status.CANCELED);
		saleDao.cancelSale(sale);
		
		Sale saleFound = saleDao.getById(sale.getId());
		assertEquals(saleCode, saleFound.getCode());
		assertEquals(Status.CANCELED, saleFound.getStatus());
	}
	
	@Test
	public void addMoreProductEqual() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A4";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		Sale saleFound = saleDao.getWithCollection(sale.getId());
		saleFound.addProduct(product, 1);
		
		assertTrue(saleFound.getQuantityTotalProducts() == 3);
		BigDecimal totalValue = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		assertTrue(saleFound.getStatus().equals(Status.STARTED));
	} 
	
	@Test
	public void addMoreDifferentProducts() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A5";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		Product prod = createProduct(saleCode, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(saleCode, prod.getCode());

		Sale saleFound = saleDao.getWithCollection(sale.getId());
		saleFound.addProduct(prod, 1);
		
		assertTrue(saleFound.getQuantityTotalProducts() == 3);
		BigDecimal totalValue = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		assertTrue(saleFound.getStatus().equals(Status.STARTED));
	} 
	
	@Test(expected = DAOException.class)
	public void salvarsaleMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
		Sale sale = createSale("A6");
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
	
		Sale sale1 = createSale("A6");
		Sale postReturn1 = saleDao.post(sale1);
		assertNull(postReturn1);
		assertTrue(sale.getStatus().equals(Status.STARTED));
	} 
	
	@Test
	public void removeProduct() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A7";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		Product prod = createProduct(saleCode, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(saleCode, prod.getCode());
		
		Sale saleFound = saleDao.getWithCollection(sale.getId());
		saleFound.addProduct(prod, 1);
		assertTrue(saleFound.getQuantityTotalProducts() == 3);
		BigDecimal totalValue = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		
		
		saleFound.removeProduct(prod, 1);
		assertTrue(saleFound.getQuantityTotalProducts() == 2);
		totalValue = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		assertTrue(saleFound.getStatus().equals(Status.STARTED));
	} 
	
	@Test
	public void deleteOneProduct() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A8";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		Product prod = createProduct(saleCode, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(saleCode, prod.getCode());
		
		Sale saleFound = saleDao.getWithCollection(sale.getId());
		saleFound.addProduct(prod, 1);
		assertTrue(saleFound.getQuantityTotalProducts() == 3);
		BigDecimal totalValue = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		
		
		saleFound.removeProduct(prod, 1);
		assertTrue(saleFound.getQuantityTotalProducts() == 2);
		totalValue = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		assertTrue(saleFound.getStatus().equals(Status.STARTED));
	} 
	
	@Test
	public void deleteAllProducts() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A9";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		Product prod = createProduct(saleCode, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(saleCode, prod.getCode());
		
		Sale saleFound = saleDao.getWithCollection(sale.getId());
		saleFound.addProduct(prod, 1);
		assertTrue(saleFound.getQuantityTotalProducts() == 3);
		BigDecimal totalValue = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(saleFound.getTotalValue().equals(totalValue));
		

		saleFound.removeAllProducts();
		assertTrue(saleFound.getQuantityTotalProducts() == 0);
		assertTrue(saleFound.getTotalValue().equals(BigDecimal.valueOf(0)));
		assertTrue(saleFound.getStatus().equals(Status.STARTED));
	} 
	
	@Test
	public void finishSale() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A10";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		sale.setStatus(Status.COMPLETED);
		saleDao.finishSale(sale);
		
		Sale saleFound = saleDao.getWithCollection(sale.getId());
		assertEquals(sale.getCode(), saleFound.getCode());
		assertEquals(Status.COMPLETED, saleFound.getStatus());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void addProductFinished() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String saleCode = "A11";
		Sale sale = createSale(saleCode);
		Sale postReturn = saleDao.post(sale);
		assertNotNull(postReturn);
		assertNotNull(sale);
		assertEquals(saleCode, sale.getCode());
		
		sale.setStatus(Status.COMPLETED);
		saleDao.finishSale(sale);
		
		Sale saleFound = saleDao.getWithCollection(sale.getId());
		assertEquals(sale.getCode(), saleFound.getCode());
		assertEquals(Status.COMPLETED, saleFound.getStatus());
		
		saleFound.addProduct(this.product, 1);
		
	}
	
	
	private void deleteProducts() throws DAOException {
		Collection<Product> list = this.productDao.getAll();
		list.forEach(prod -> {
			try {
				this.productDao.delete(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private void deleteSale() throws DAOException {
		Collection<Sale> list = this.saleExcludeDao.getAll();
		list.forEach(prod -> {
			try {
				this.saleExcludeDao.delete(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private Product createProduct(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Product product = new Product();
		product.setCode(codigo);
		product.setDescription("Produto 1");
		product.setName("Produto 1");
		product.setValue(valor);
		productDao.post(product);
		return product;
	}

	private Client createClient() throws TipoChaveNaoEncontradaException, DAOException {
		Client client = new Client();
		client.setDocument(rd.nextLong());
		client.setName("Rodrigo");
		client.setCity("São Paulo");
		client.setAddress("End");
		client.setState("SP");
		client.setNumber(10);
		client.setPhone(1199999999L);
		clientDao.post(client);
		return client;
	}
	
	private Sale createSale(String codigo) {
		Sale sale = new Sale();
		sale.setCode(codigo);
		sale.setSaleDate(Instant.now());
		sale.setClient(this.client);
		sale.setStatus(Status.STARTED);
		sale.addProduct(this.product, 2);
		return sale;
	}
}
