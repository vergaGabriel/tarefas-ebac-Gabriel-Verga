package br.com.gverga;


import br.com.gverga.dao.AccessoryDao;
import br.com.gverga.dao.IAccessoryDao;
import br.com.gverga.domain.Accessory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AccessoryTest {
    private Accessory accessoryInit;
    private IAccessoryDao accessoryDao;

    public AccessoryTest() {
        accessoryDao = new AccessoryDao();
    }

    @Before
    public void init() {
        accessoryInit = new Accessory();
        accessoryInit.setCode("A1");
        accessoryInit.setName("Leather bench");
        accessoryInit.setOptional(true);
    }

    @Test
    public void postTest() {
        Accessory accessoryCreated = accessoryDao.post(accessoryInit);

        Assert.assertNotNull(accessoryCreated);
        Assert.assertNotNull(accessoryCreated.getId());
    }

    @Test
    public void getAllTest() {
        List<Accessory> accessories = accessoryDao.getAll();

        Assert.assertFalse(accessories.isEmpty());
    }

    @Test
    public void getTest() {
        Accessory accessoryFound = accessoryDao.getByCode(accessoryInit.getCode());

        Assert.assertNotNull(accessoryFound);
    }

    @Test
    public void updateTest() {
        Accessory accessoryUpd = new Accessory();
        accessoryUpd.setCode("A1");
        accessoryUpd.setName("Leather benche");
        accessoryUpd.setOptional(false);

        Boolean accessoryUpdated = accessoryDao.update(accessoryUpd);

        Assert.assertTrue(accessoryUpdated);
    }

    @Test
    public void deleteTest() {
        Boolean accessoryDeleted = accessoryDao.delete(accessoryInit.getCode());

        Assert.assertTrue(accessoryDeleted);
    }
}
