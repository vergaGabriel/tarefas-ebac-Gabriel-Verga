/**
 * 
 */
package br.com.gverga.services;

import br.com.gverga.dao.IProdutoDAO;
import br.com.gverga.domain.Produto;
import br.com.gverga.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
