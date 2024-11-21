package br.com.gverga.dao;

import br.com.gverga.domain.Accessory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccessoryDao implements IAccessoryDao{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AccessoryDao() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("DealershipJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Accessory post(Accessory accessory) {
        entityManager.getTransaction().begin();
        entityManager.persist(accessory);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return accessory;
    }

    @Override
    public Boolean delete(String accessoryCode) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT a FROM Accessory a WHERE a.code = :accessoryCode";
        TypedQuery<Accessory> query = entityManager.createQuery(jpql, Accessory.class);
        query.setParameter("accessoryCode", accessoryCode);

        Accessory accessoryFound = null;

        try {
            accessoryFound = query.getSingleResult();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();

            return false;
        }

        entityManager.remove(accessoryFound);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return true;
    }

    @Override
    public List<Accessory> getAll() {
        entityManager.getTransaction().begin();

        String jpql = "SELECT a FROM Accessory a";
        TypedQuery<Accessory> query = entityManager.createQuery(jpql, Accessory.class);
        List<Accessory> accessoriesFound = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return accessoriesFound;
    }

    @Override
    public Accessory getByCode(String accessoryCode) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT a FROM Accessory a WHERE a.code = :accessoryCode";
        TypedQuery<Accessory> query = entityManager.createQuery(jpql, Accessory.class);
        query.setParameter("accessoryCode", accessoryCode);

        Accessory accessoryFound = null;

        try {
            accessoryFound = query.getSingleResult();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();

            return null;
        }

        entityManager.close();
        entityManagerFactory.close();

        return accessoryFound;
    }

    @Override
    public Boolean update(Accessory accessoryUpd) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT a FROM Accessory a WHERE a.code = :accessoryCode";
        TypedQuery<Accessory> query = entityManager.createQuery(jpql, Accessory.class);
        query.setParameter("accessoryCode", accessoryUpd.getCode());

        Accessory accessoryFound = query.getSingleResult();

        Accessory accessoryToUpdate = entityManager.find(Accessory.class, accessoryFound.getId());
        if (accessoryToUpdate != null) {
            accessoryToUpdate.setName(accessoryUpd.getName());
            accessoryToUpdate.setOptional(accessoryUpd.getOptional());

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
