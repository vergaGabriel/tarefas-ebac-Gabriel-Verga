package estruturas;

public class Fifo {
    private int[] elementos;
    private int frente;
    private int tras;
    private int tamanho;
    private int capacidade;

    public Fifo(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.frente = 0;
        this.tras = -1;
        this.tamanho = 0;
    }

    public void enqueue(int valor) {
        if (tamanho == capacidade) {
            System.out.println("Erro: Fila cheia!");
            return;
        }
        tras = (tras + 1) % capacidade;
        elementos[tras] = valor;
        tamanho++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Erro: Fila vazia!");
            return -1;
        }
        int valor = elementos[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return valor;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Erro: Fila vazia!");
            return -1;
        }
        return elementos[frente];
    }

    public int rear() {
        if (isEmpty()) {
            System.out.println("Erro: Fila vazia!");
            return -1;
        }
        return elementos[tras];
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void exibir() {
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            int index = (frente + i) % capacidade;
            System.out.print(elementos[index] + " ");
        }
        System.out.println();
    }
}
