public class ColaConcurrente {
    private int size;
    private final int capacidad = 10;
    private Node first;
    private Node last;

    public ColaConcurrente() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    // Agregar al final
    public synchronized void push(Node node) throws InterruptedException {

        while(size == capacidad) {
            wait();     //Si esta llena al cola, espera a que se vacie
        }

        if (first == null) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }

        size++;
        notifyAll(); //Avisa a los lectores que estaban esperando de que ya pueden leer
    }

    // Eliminar por posición
    public synchronized Node pop() throws InterruptedException {

        while(first == null) {
            wait(); //Esperan a que haya algo para leer
        }

        Node nodo = first;
        first = first.getNext();

        if (first != null) first.setPrevious(null);
        else last = null;

        size--;
        notifyAll(); //Despierta a los escritores
        return nodo;
    }

    // Mostrar lista
    public void show() {
        Node p = first;
        while (p != null) {
            System.out.println(p);
            p = p.getNext();
        }
    }
}
