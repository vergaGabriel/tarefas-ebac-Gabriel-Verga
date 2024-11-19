package br.com.gverga;

import br.com.gverga.dao.CursoDao;
import br.com.gverga.dao.ICursoDao;
import br.com.gverga.dao.IMatriculaDao;
import br.com.gverga.dao.MatriculaDao;
import br.com.gverga.domain.Curso;
import br.com.gverga.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class MatriculaTest {
    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Matricula matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(2000d);
        matricula.setCurso(curso);

        matricula = matriculaDao.cadastrar(matricula);

        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("Curso Test");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);

        return curso;
    }
}
