package br.com.gverga.singleton;

public class DemoSingletonPropriedade {
    public static void main(String[] args){
        SingletonPropriedade singleton =  SingletonPropriedade.getInstance("hello");
        SingletonPropriedade singleton1 =  SingletonPropriedade.getInstance("hello1");

        System.out.println(singleton.getValue());
        System.out.println(singleton1.getValue());
    }
}
