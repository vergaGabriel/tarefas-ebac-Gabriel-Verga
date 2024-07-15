package br.com.gverga.cadastro.dao;

import br.com.gverga.cadastro.dao.generic.GenericDAO;
import br.com.gverga.cadastro.domain.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
        Map<Long, Produto> mapaInterno = this.map.get(getClassType());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            this.map.put(getClassType(), mapaInterno);
        }
    }

    @Override
    public Class<Produto> getClassType() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto produto, Produto entityCadastrado) {
        entityCadastrado.setNome(produto.getNome());
        entityCadastrado.setPreco(produto.getPreco());
    }
}
