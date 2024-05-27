public class Node<E> {
    private E nodeContent;
    private Node<E> nextNode;
    private Node<E> previousNode;

    public Node(E nodeContent) {
        this.nodeContent = nodeContent;
        this.nextNode = null;
        this.previousNode = null;
    }

    public Node(E nodeContent, Node<E> nextNode, Node<E> previousNode) {
        this.nodeContent = nodeContent;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
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

    public Node<E> getPrevious() {
        return previousNode;
    }

    // setters
    public void setContent(E content) {
        this.nodeContent = content;
    }

    public void setNext(Node<E> next) {
        this.nextNode = next;
    }

    public void setPrevious(Node<E> previous) {
        this.previousNode = previous;
    }

    public int compareTo(Node<E> max) {
        return max.getContentString().compareTo(getContentString());
    }
}