package estruturas;

public class ListaEncadeada {
    private Node cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void push(Node node) {
        if (cabeca == null) {
            cabeca = node;
        } else {
            Node atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        tamanho++;
    }

    public Node pop() {
        if (cabeca == null) {
            return null;
        }

        if (cabeca.proximo == null) {
            Node removido = cabeca;
            cabeca = null;
            tamanho--;
            return removido;
        }

        Node atual = cabeca;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        Node removido = atual.proximo;
        atual.proximo = null;
        tamanho--;
        return removido;
    }

    public void insert(int index, Node node) {
        if (index < 0 || index > tamanho) {
            System.out.println("Índice inválido.");
            return;
        }

        if (index == 0) {
            node.proximo = cabeca;
            cabeca = node;
        } else {
            Node atual = cabeca;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            node.proximo = atual.proximo;
            atual.proximo = node;
        }
        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice inválido.");
            return;
        }

        if (index == 0) {
            cabeca = cabeca.proximo;
        } else {
            Node atual = cabeca;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public Node elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice inválido.");
            return null;
        }

        Node atual = cabeca;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        Node atual = cabeca;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}

