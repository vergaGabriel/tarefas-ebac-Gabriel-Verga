public abstract class CarFactory {
    public Car create(String requestedGrade) {
        Car car = retriveCar(requestedGrade);

        return prepareCar(car);
    }

    private Car prepareCar(Car car) {
        car.clean();
        car.mechanicCheck();
        car.fuelCar();
        return car;
    }

    abstract Car retriveCar(String requestedGrade);
}
