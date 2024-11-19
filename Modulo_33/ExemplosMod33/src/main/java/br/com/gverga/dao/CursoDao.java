package br.com.gverga.dao;

import br.com.gverga.domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoDao implements ICursoDao{
    @Override
    public Curso cadastrar(Curso curso) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public List<Curso> buscar(Long id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = "SELECT e FROM " + Curso.class.getSimpleName() + " e";
        List<Curso> curso = entityManager.createQuery(jpql, Curso.class).getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }
}
