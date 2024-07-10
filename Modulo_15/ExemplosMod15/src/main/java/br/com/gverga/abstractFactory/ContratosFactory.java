package br.com.gverga.abstractFactory;

public class ContratosFactory extends Factory{
    @Override
    Car retriveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Corolla(100, "cheio", "azul");
        } else {
            return null;
        }
    }
}
