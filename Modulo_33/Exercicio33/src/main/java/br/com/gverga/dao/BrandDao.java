package br.com.gverga.dao;

import br.com.gverga.domain.Brand;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BrandDao implements IBrandDao{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public BrandDao() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("DealershipJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Brand post(Brand brand) {
        entityManager.getTransaction().begin();
        entityManager.persist(brand);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return brand;
    }

    @Override
    public Boolean delete(String brandCode) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT b FROM Brand b WHERE b.code = :brandCode";
        TypedQuery<Brand> query = entityManager.createQuery(jpql, Brand.class);
        query.setParameter("brandCode", brandCode);

        Brand brandFound = null;

        try {
            brandFound = query.getSingleResult();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();

            return false;
        }

        entityManager.remove(brandFound);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return true;
    }

    @Override
    public List<Brand> getAll() {
        entityManager.getTransaction().begin();

        String jpql = "SELECT b FROM Brand b";
        TypedQuery<Brand> query = entityManager.createQuery(jpql, Brand.class);
        List<Brand> brandsFound = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return brandsFound;
    }

    @Override
    public Brand getByCode(String brandCode) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT b FROM Brand b WHERE b.code = :brandCode";
        TypedQuery<Brand> query = entityManager.createQuery(jpql, Brand.class);
        query.setParameter("brandCode", brandCode);

        Brand brandFound = null;

        try {
            brandFound = query.getSingleResult();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();

            return null;
        }

        entityManager.close();
        entityManagerFactory.close();

        return brandFound;
    }

    @Override
    public Boolean update(Brand brandUpd) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT b FROM Brand b WHERE b.code = :brandCode";
        TypedQuery<Brand> query = entityManager.createQuery(jpql, Brand.class);
        query.setParameter("brandCode", brandUpd.getCode());

        Brand brandFound = query.getSingleResult();

        Brand brandToUpdate = entityManager.find(Brand.class, brandFound.getId());
        if (brandToUpdate != null) {
            brandToUpdate.setName(brandUpd.getName());

            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            return true;
        }

        entityManager.getTransaction().rollback();

        entityManager.close();
        entityManagerFactory.close();

        return false;
    }
}
