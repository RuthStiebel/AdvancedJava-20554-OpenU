import java.util.Stack;

/**
 * A generic linked list implementation.
 * 
 * @param <E> The type of elements stored in the linked list.
 */
public class LinkedList<E> {
    private Node<E> headNode;
    private Node<E> tailNode;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        headNode = null;
        tailNode = null;
    }

    /**
     * Gets the head node of the linked list.
     * 
     * @return The head node.
     */
    public Node<E> getHead() {
        return headNode;
    }

    /**
     * Gets the tail node of the linked list.
     * 
     * @return The tail node.
     */
    public Node<E> getTail() {
        return tailNode;
    }

    /**
     * Adds a new node to the end of the linked list.
     * 
     * @param newNode The node to be added.
     */
    public void addNode(Node<E> newNode) {
        if (tailNode == null) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.setNext(newNode);
            tailNode = newNode;
        }
    }

    /**
     * Removes and returns the content of the first node in the linked list.
     * 
     * @return The content of the first node.
     * @throws EmptyListException If the list is empty.
     */
    public E removeFirstNode() throws EmptyListException {
        if (headNode == null)
            throw new EmptyListException("List is empty!");
        E content = headNode.getContent();
        headNode = headNode.getNext();
        return content;
    }

    /**
     * Creates a new linked list with the elements flipped in order.
     * 
     * @return A new linked list with the elements flipped.
     */
    public LinkedList<E> flipList() {
        LinkedList<E> flippedList = new LinkedList<>();
        Stack<E> listStack = new Stack<E>();
        Node<E> current = this.headNode;

        while (current != null) {
            listStack.push(current.getContent());
            current = current.getNext();
        }

        while (!listStack.isEmpty()) {
            Node<E> newNode = new Node<>(listStack.pop());
            flippedList.addNode(newNode);
        }

        return flippedList;
    }

    /**
     * Returns a string representation of the linked list.
     * 
     * @return A string containing the contents of the linked list.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> current = headNode;
        while (current != null) {
            stringBuilder.append(current.getContent()).append("\n");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }
}
