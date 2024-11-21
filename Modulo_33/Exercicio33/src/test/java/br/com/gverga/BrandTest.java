package br.com.gverga;

import br.com.gverga.dao.BrandDao;
import br.com.gverga.dao.IBrandDao;
import br.com.gverga.domain.Brand;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BrandTest {
    private Brand brandInit;
    private IBrandDao brandDao;

    public BrandTest() {
        brandDao = new BrandDao();
    }

    @Before
    public void init() {
        brandInit = new Brand();
        brandInit.setCode("A1");
        brandInit.setName("Honda");
    }

    @Test
    public void postTest() {
        Brand brandCreated = brandDao.post(brandInit);

        Assert.assertNotNull(brandCreated);
        Assert.assertNotNull(brandCreated.getId());
    }

    @Test
    public void getAllTest() {
        List<Brand> brands = brandDao.getAll();

        Assert.assertFalse(brands.isEmpty());
    }

    @Test
    public void getTest() {
        Brand brandFound = brandDao.getByCode(brandInit.getCode());

        Assert.assertNotNull(brandFound);
    }

    @Test
    public void updateTest() {
        Brand brandUpd = new Brand();
        brandUpd.setCode("A1");
        brandUpd.setName("Hondi");

        Boolean brandUpdated = brandDao.update(brandUpd);

        Assert.assertTrue(brandUpdated);
    }

    @Test
    public void deleteTest() {
        Boolean brandDeleted = brandDao.delete(brandInit.getCode());

        Assert.assertTrue(brandDeleted);
    }
}
