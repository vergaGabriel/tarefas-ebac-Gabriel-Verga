package br.com.gverga.abstractFactory;

public class SemContratosFactory extends Factory{
    @Override
    Car retriveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Brasilia(60, "cheio", "amarela");
        } else {
            return null;
        }
    }
}
