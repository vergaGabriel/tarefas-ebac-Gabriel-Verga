package br.com.gverga.ExemplosGenerics;

import java.util.ArrayList;
import java.util.List;

import br.com.gverga.ExemplosGenerics.fruta.Fruta;
import br.com.gverga.ExemplosGenerics.fruta.Banana;
import br.com.gverga.ExemplosGenerics.fruta.Maca;

public class ExemplosJavaGenerics {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("oi");
        lista.add("1");

       imprimir(lista);

        List<Long> listaLong = new ArrayList<>();
        listaLong.add(1L);
        listaLong.add(2L);

        imprimir2(listaLong);

        List<Fruta> listaFruta = new ArrayList<>();
        listaFruta.add(new Maca());
        listaFruta.add(new Banana());

        imprimirFrutas(listaFruta);
    }

//    public static void imprimir(List<Object> lista) {
//        for (Object st : lista) {
//            System.out.println(st);
//        }
//    }

//    public static void imprimir1(List<Long> lista) {
//        for (Long st : lista) {
//            System.out.println(st);
//        }
//    }

    public static void imprimirFrutas(List<? extends Fruta> lista) {
        for (Fruta fruta : lista) {
            System.out.println("Lista de qualquer coisa: " + fruta);
        }
    }
    public static void imprimir2(List<?> lista) {
        for (Object st : lista) {
            if (st instanceof Long) {
                Long stLong = (Long) st;
                System.out.println("Lista de qualquer coisa: " + stLong);

            } else {
                System.out.println("Lista de qualquer coisa: " + st);

            }
        }
    }

    public static <T> void imprimir(List<T> lista) {
        for (T st : lista) {
            System.out.println(st);
        }
    }

    public static <T> T pegarPrimeiroLista(List<T> lista) {
        return lista.getFirst();
    }
}
