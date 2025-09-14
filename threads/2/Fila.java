
import java.util.LinkedList;
import java.util.List;

public class Fila {
    private final List<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait();
        }
        fila.add(item);
        System.out.println("Produtor adicionou: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }
        int item = fila.remove(0);
        System.out.println("Consumidor retirou: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll();
        return item;
    }
}