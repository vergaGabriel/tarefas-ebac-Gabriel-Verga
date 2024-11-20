package br.com.gverga.dao;

import br.com.gverga.domain.Car;

import java.util.List;

public interface ICarDao {
    public Car post(Car car);

    public Boolean delete(String carCode);

    public List<Car> getAll();

    public Car getByCode(String carCode);

    public Boolean update(Car carUpd);
}
