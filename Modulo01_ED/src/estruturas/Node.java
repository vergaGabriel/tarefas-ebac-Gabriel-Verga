package estruturas;

public class Node {
    int valor;
    Node proximo;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
