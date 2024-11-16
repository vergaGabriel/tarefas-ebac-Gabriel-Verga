package br.com.gverga.dao;

import br.com.gverga.domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDao implements ICursoDao{
    @Override
    public Curso cadastrar(Curso curso) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Teste");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }
}
