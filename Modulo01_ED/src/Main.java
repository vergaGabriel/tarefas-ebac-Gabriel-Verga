import estruturas.Fifo;
import estruturas.ListaEncadeada;
import estruturas.Node;
import estruturas.Stack;

public class Main {
    public static void main(String[] args) {
        Stack pilha = new Stack(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.exibir();

        System.out.println("Topo da pilha: " + pilha.top());
        System.out.println("Tamanho da pilha: " + pilha.size());
        System.out.println("Está vazia? " + pilha.isEmpty());

        System.out.println("Pop: " + pilha.pop());
        pilha.exibir();

        Fifo fila = new Fifo(5);

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        fila.exibir();

        System.out.println("Frente da fila: " + fila.front());
        System.out.println("Fim da fila: " + fila.rear());
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Está vazia? " + fila.isEmpty());

        System.out.println("Dequeue: " + fila.dequeue());
        fila.exibir();

        ListaEncadeada lista = new ListaEncadeada();

        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));
        lista.printList();

        lista.insert(1, new Node(15));
        lista.printList();

        lista.remove(2);
        lista.printList();

        Node elemento = lista.elementAt(1);
        System.out.println("Elemento no índice 1: " + elemento);

        Node removido = lista.pop();
        System.out.println("Removido do fim: " + removido); 

        lista.printList();

        System.out.println("Tamanho da lista: " + lista.size());
    }
}