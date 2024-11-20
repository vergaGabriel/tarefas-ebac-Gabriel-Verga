package br.com.gverga.dao;

import br.com.gverga.domain.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarDao implements ICarDao{

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public CarDao() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("DealershipJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Car post(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return car;
    }

    @Override
    public Boolean delete(String carCode) {
         entityManager.getTransaction().begin();

        String jpql = "SELECT c FROM Car c WHERE c.code = :carCode";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        query.setParameter("carCode", carCode);

        Car carFound = null;

        try {
            carFound = query.getSingleResult();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();

            return false;
        }

        entityManager.remove(carFound);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return true;
    }

    @Override
    public List<Car> getAll() {
        entityManager.getTransaction().begin();

        String jpql = "SELECT c FROM Car c";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        List<Car> carsFound = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return carsFound;
    }

    @Override
    public Car getByCode(String carCode) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT c FROM Car c WHERE c.code = :carCode";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        query.setParameter("carCode", carCode);

        Car carFound = null;

        try {
            carFound = query.getSingleResult();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();

            return null;
        }

        entityManager.close();
        entityManagerFactory.close();

        return carFound;
    }

    @Override
    public Boolean update(Car carUpd) {
        entityManager.getTransaction().begin();

        String jpql = "SELECT c FROM Car c WHERE c.code = :carCode";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        query.setParameter("carCode", carUpd.getCode());

        Car carFound = query.getSingleResult();

        Car carToUpdate = entityManager.find(Car.class, carFound.getId());
        if (carToUpdate != null) {
            carToUpdate.setColor(carUpd.getColor());
            carToUpdate.setModel(carUpd.getModel());
            carToUpdate.setYear(carUpd.getYear());

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
