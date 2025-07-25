package estruturas;

public class Stack {
    private int[] elementos;
    private int topo;
    private int capacidade;

    public Stack(int capacidade) {
        this.capacidade = capacidade;
        elementos = new int[capacidade];
        topo = -1; // pilha começa vazia
    }

    public void push(int valor) {
        if (topo == capacidade - 1) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        topo++;
        elementos[topo] = valor;
    }

    public int pop() {
        if (topo == -1) {
            System.out.println("Erro: Pilha vazia!");
            return -1; // valor indicativo de erro
        }
        int valor = elementos[topo];
        topo--;
        return valor;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }

    public void exibir() {
        System.out.print("Pilha: ");
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}
