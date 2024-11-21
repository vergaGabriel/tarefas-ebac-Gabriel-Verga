package br.com.gverga.dao;

import br.com.gverga.domain.Accessory;

import java.util.List;

public interface IAccessoryDao {
    public Accessory post(Accessory accessory);

    public Boolean delete(String accessoryCode);

    public List<Accessory> getAll();

    public Accessory getByCode(String accessoryCode);

    public Boolean update(Accessory accessoryUpd);
}
