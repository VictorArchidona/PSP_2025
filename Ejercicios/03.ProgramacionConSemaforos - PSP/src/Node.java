public class Node {
    private String mensaje;
    private Node next;
    private Node previous;

    public Node() {}

    public Node(String mensaje) {
        this.mensaje = mensaje;
        this.next = null;
        this.previous = null;
    }

    public String getContent() {
        return mensaje;
    }

    public void setContent(String content) {
        this.mensaje = content;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Content = " + this.mensaje;
    }
}
