package br.com.gverga.dao;

import br.com.gverga.domain.Brand;

import java.util.List;

public interface IBrandDao {

    public Brand post(Brand brand);

    public Boolean delete(String brandCode);

    public List<Brand> getAll();

    public Brand getByCode(String brandCode);

    public Boolean update(Brand brandUpd);
}
