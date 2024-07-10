public class NoContractFactory extends CarFactory{
    @Override
    Car retriveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Uno(70, "full", "white");
        } else {
            return new Celta(90, "full", "red");
        }
    }
}
