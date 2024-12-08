/**
 * 
 */
package br.com.gverga;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author rodrigo.pires
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClientDaoTest.class, ProductDAOTest.class, SaleDAOTest.class})
public class AllTests {

}
