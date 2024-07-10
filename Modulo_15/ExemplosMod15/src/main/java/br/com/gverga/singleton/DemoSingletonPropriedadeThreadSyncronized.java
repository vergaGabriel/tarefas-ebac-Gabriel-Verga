package br.com.gverga.singleton;

public class DemoSingletonPropriedadeThreadSyncronized {
    public static void main(String[] args) {
        Thread threadTeste = new Thread(new ThreadTeste());
        Thread threadTeste1 = new Thread(new ThreadTeste1());

        threadTeste.start();
        threadTeste1.start();
    }

    static class ThreadTeste implements Runnable {
        @Override
        public void run() {
            SingletonPropriedadeSyncronized singleton = SingletonPropriedadeSyncronized.getInstance("teste");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadTeste1 implements Runnable {
        @Override
        public void run() {
            SingletonPropriedadeSyncronized singleton = SingletonPropriedadeSyncronized.getInstance("teste1");
            System.out.println(singleton.getValue());
        }
    }
}
