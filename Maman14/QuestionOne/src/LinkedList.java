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

    public LinkedList<E> flipList() {
        LinkedList<E> flippedList = new LinkedList<>();
        Node<E> current = this.headNode;
    
        while (current != null) {
            // Create a new node with the same data as current node
            Node<E> newNode = new Node<>(current.getContent());
            
            // Insert the new node at the beginning of the flipped list
            if (flippedList.headNode == null) {
                flippedList.headNode = newNode;
                flippedList.tailNode = newNode;
            } else {
                newNode.setNext(flippedList.headNode);
                flippedList.headNode.setPrevious(newNode);
                flippedList.headNode = newNode;
            }
            
            // Move to the next node in the original list
            current = current.getNext();
        }
    
        return flippedList;
    }
    

    // toString
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
