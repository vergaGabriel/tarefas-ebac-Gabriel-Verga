package br.com.gverga.services.generic;

import br.com.gverga.domain.Persistente;
import br.com.gverga.exception.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente> {
    Boolean salvar(T client) throws TipoChaveNaoEncontradaException;

    T buscarPorCodigo(Long code);

    void excluir(Long cpf);

    void alterar(T client) throws TipoChaveNaoEncontradaException;
}
