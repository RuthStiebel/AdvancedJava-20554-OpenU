public class Node<E> {
    private E nodeContent;
    private E nextNode;

    public Node(E nodeContent) {
        this.nodeContent = nodeContent;
        this.nextNode = null;
    }

    public Node(E nodeContent, E nextNode) {
        this.nodeContent = nodeContent;
        this.nextNode = nextNode;
    }

    // getters
    public E getContent() {
        return nodeContent;
    }

    public E getNext() {
        return nextNode;
    }
    // setters
    public void setContent (E content) {
        this.nodeContent = content;
    }

    public void setNext (E next) {
        this.nextNode = next;
    }
}
