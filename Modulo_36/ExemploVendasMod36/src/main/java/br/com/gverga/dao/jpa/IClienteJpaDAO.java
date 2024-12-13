/**
 * 
 */
package br.com.gverga.dao.jpa;

import br.com.gverga.dao.generic.jpa.IGenericJapDAO;
import br.com.gverga.domain.jpa.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
