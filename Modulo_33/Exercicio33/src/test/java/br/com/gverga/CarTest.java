package br.com.gverga;

import br.com.gverga.dao.BrandDao;
import br.com.gverga.dao.CarDao;
import br.com.gverga.dao.IBrandDao;
import br.com.gverga.dao.ICarDao;
import br.com.gverga.domain.Accessory;
import br.com.gverga.domain.Brand;
import br.com.gverga.domain.Car;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarTest {
    private Car carInit;

    private ICarDao carDao;
    private IBrandDao brandDao;

    public CarTest() {
        carDao = new CarDao();
        brandDao = new BrandDao();
    }

    @Before
    public void init() {
        carInit = new Car();
        carInit.setCode("A1");
        carInit.setModel("Sedan");
        carInit.setColor("Black");
        carInit.setYear(2010);
        carInit.setName("Civic");
    }

    @Test
    public void postTest() {
        Brand brand = createBrand();
        carInit.setBrand(brand);

        Accessory accessory1 = createAcessory("A1");
        Accessory accessory2 = createAcessory("A2");
        carInit.add(accessory1);
        carInit.add(accessory2);

        Car carCreated = carDao.post(carInit);

        Assert.assertNotNull(carCreated);
        Assert.assertNotNull(carCreated.getId());
    }

    @Test
    public void getAllTest() {
        List<Car> cars = carDao.getAll();

        Assert.assertFalse(cars.isEmpty());
    }

    @Test
    public void getTest() {
        Car carFound = carDao.getByCode(carInit.getCode());

        Assert.assertNotNull(carFound);
    }

    @Test
    public void updateTest() {
        Car carUpd = new Car();
        carUpd.setCode("A1");
        carUpd.setModel("Sedan");
        carUpd.setColor("White");
        carUpd.setYear(2012);
        carUpd.setName("Civic");

        Boolean carUpdated = carDao.update(carUpd);

        Assert.assertTrue(carUpdated);
    }

    @Test
    public void deleteTest() {
        Boolean carDeleted = carDao.delete(carInit.getCode());

        Assert.assertTrue(carDeleted);
    }

    public Brand createBrand() {
        Brand brand = new Brand();
        brand.setCode("A1");
        brand.setName("Honda");
        brand = brandDao.post(brand);

        return brand;
    }

    public Accessory createAcessory(String code) {
        Accessory accessory = new Accessory();
        accessory.setCode(code);
        accessory.setName("Accessory Test");
        accessory.setOptional(true);

        return accessory;
    }
}
