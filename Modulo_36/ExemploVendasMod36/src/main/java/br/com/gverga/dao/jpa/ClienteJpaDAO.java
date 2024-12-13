/**
 * 
 */
package br.com.gverga.dao.jpa;

import br.com.gverga.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.gverga.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
