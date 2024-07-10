package br.com.gverga.singleton;

public class DemoSingleton {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);

        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1);
    }
}
