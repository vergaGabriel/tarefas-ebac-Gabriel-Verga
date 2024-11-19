package br.com.gverga;

import br.com.gverga.dao.CursoDao;
import br.com.gverga.dao.ICursoDao;
import br.com.gverga.domain.Curso;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso Test");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
    }

    @Test
    public void buscar() {
        List<Curso> curso = cursoDao.buscar(1L);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.get(0).getId());
    }
}
