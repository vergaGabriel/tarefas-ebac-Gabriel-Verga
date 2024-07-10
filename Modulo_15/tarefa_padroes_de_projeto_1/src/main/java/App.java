public class App {
    public static void main(String[] args) {
        Customer cliente = new Customer("A", false);
        CarFactory factory = getFactory(cliente);
        Car car = factory.create(cliente.getGradeRequest());
        car.startEngine();
    }

    private static CarFactory getFactory(Customer cliente) {
        if (cliente.hasCompanyContract()) {
            return new ContractFactory();
        } else {
            return new NoContractFactory();
        }
    }
}
