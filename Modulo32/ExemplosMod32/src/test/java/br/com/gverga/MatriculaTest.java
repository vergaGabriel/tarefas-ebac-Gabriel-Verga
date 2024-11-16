package br.com.gverga;

import br.com.gverga.dao.IMatriculaDao;
import br.com.gverga.dao.MatriculaDao;
import br.com.gverga.domain.Matricula;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class MatriculaTest {
    private IMatriculaDao matriculaDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void cadastrar() {
        Matricula matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(2000d);

        matricula = matriculaDao.cadastrar(matricula);

        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());
    }
}
