/**
 * 
 */
package br.com.gverga.dao.jpa;

import br.com.gverga.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.gverga.domain.jpa.ClienteJpa2;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
