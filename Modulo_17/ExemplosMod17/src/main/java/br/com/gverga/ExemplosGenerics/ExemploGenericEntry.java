package br.com.gverga.ExemplosGenerics;

public class ExemploGenericEntry {

    public static void main(String[] args) {
        GenericEntry<String, Long> entry = new GenericEntry<>("Teste", 111L);
        System.out.println(entry.getData());

        GenericEntry<Long, Integer> entryLong = new GenericEntry<>(111L, 10);
        System.out.println(entryLong.getData());

    }
}
