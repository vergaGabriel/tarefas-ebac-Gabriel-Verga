public class ContractFactory extends CarFactory{
    @Override
    Car retriveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Jetta(200, "full", "black");
        } else {
            return new Corolla(100, "full", "beige");
        }
    }
}
