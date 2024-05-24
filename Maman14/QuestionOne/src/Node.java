public class Node<E> {
    private E nodeContent;
    private Node<E> nextNode;

    public Node(E nodeContent) {
        this.nodeContent = nodeContent;
        this.nextNode = null;
    }

    public Node(E nodeContent, Node<E> nextNode) {
        this.nodeContent = nodeContent;
        this.nextNode = nextNode;
    }

    // getters
    public E getContent() {
        return nodeContent;
    }

    public String getContentString() {
        return nodeContent.toString();
    }

    public Node<E> getNext() {
        return nextNode;
    }

    // setters
    public void setContent(E content) {
        this.nodeContent = content;
    }

    public void setNext(Node<E> next) {
        this.nextNode = next;
    }

    public int compareTo(Node<E> max) {
        return max.getContentString().compareTo(getContentString());
    }
}