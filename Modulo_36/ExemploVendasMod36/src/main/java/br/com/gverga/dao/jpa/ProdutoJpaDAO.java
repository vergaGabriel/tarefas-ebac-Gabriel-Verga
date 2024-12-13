/**
 * 
 */
package br.com.gverga.dao.jpa;

import br.com.gverga.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.gverga.domain.jpa.ProdutoJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
