package br.com.gverga.services.generic;

import br.com.gverga.dao.generic.IGenericDAO;
import br.com.gverga.domain.Client;
import br.com.gverga.domain.Persistente;
import br.com.gverga.exception.TipoChaveNaoEncontradaException;

public abstract class GenericService <T extends Persistente> implements IGenericService<T> {

    protected IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean salvar(T client) throws TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(client);
    }

    @Override
    public T buscarPorCodigo(Long code) {
        return this.dao.consultar(code);
    }

    @Override
    public void excluir(Long cpf) {
        this.dao.excluir(cpf);
    }

    @Override
    public void alterar(T client) throws TipoChaveNaoEncontradaException {
        this.dao.alterar(client);
    }
}
