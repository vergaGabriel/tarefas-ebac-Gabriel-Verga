package br.com.gverga.ExemplosGenerics;

public class GenericEntry<T, E> {

    private T data;

    private E codigo;

    public GenericEntry(T data, E codigo) {
        this.data = data;
        this.codigo = codigo;
    }

    public T getData() {
        return data;
    }

    public E getCodigo() {
        return codigo;
    }
}
