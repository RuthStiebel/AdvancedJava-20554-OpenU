public class List<E> extends Exception{
    private Node<E> headNode;
    private Node<E> tailNode;

    public List () {
        headNode = null;
        tailNode = null;
    }

    //getters
    public Node<E> getHead () {
        return headNode;
    }

    public Node<E> getTail () {
        return tailNode;
    }

    //add
    public void addNode (Node<E> newNode) {
        tailNode.setNext(newNode);
        tailNode = newNode;
    }

    //remove
    public E removeFirstNode {
        if (headNode == null)
            throw EmptyListException;
        E content = headNode.getContent();
        headNode = headNode.getNext();
        return content;
    }

    //toString
}
