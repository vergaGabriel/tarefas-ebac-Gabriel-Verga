package br.com.gverga.dao;

import br.com.gverga.domain.Curso;

import java.util.List;

public interface ICursoDao {

    public Curso cadastrar(Curso curso);

    public List<Curso> buscar(Long id);
}
