package br.com.gverga.builder;

public class Demo {

    public static void main(String[] args) {
        //Gerente gerente = new Gerente(new CheeseBurgerBuild());
        Gerente gerente = new Gerente();
        gerente.setBuilder(new CheeseBurgerBuild());
        Burger burger = gerente.buildBurger();
        burger.print();

        //Gerente gerente1 = new Gerente(new VeganBurgerBuild());
        gerente.setBuilder(new VeganBurgerBuild());
        Burger burger1 = gerente.buildBurger();
        burger1.print();
    }
}
