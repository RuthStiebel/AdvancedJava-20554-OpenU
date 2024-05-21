public class LinkedList<E> {
    private Node<E> headNode;
    private Node<E> tailNode;

    public LinkedList() {
        headNode = null;
        tailNode = null;
    }

    // getters
    public Node<E> getHead() {
        return headNode;
    }

    public Node<E> getTail() {
        return tailNode;
    }

    // add
    public void addNode(Node<E> newNode) {
        if (tailNode == null) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.setNext(newNode);
            tailNode = newNode;
        }
    }

    // remove
    public E removeFirstNode() throws Exception {
        if (headNode == null)
            throw new EmptyListException("List is empty");
        E content = headNode.getContent();
        headNode = headNode.getNext();
        return content;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> current = headNode;
        while (current != null) {
            stringBuilder.append(current.getContent()).append(" ");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }
}
