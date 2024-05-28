/**
 * A node in a doubly linked list.
 * 
 * @param <E> The type of element stored in the node.
 */
public class Node<E> {
    private E nodeContent;
    private Node<E> nextNode;
    private Node<E> previousNode;

    /**
     * Constructs a node with the given content.
     * 
     * @param nodeContent The content of the node.
     */
    public Node(E nodeContent) {
        this.nodeContent = nodeContent;
        this.nextNode = null;
        this.previousNode = null;
    }

    /**
     * Constructs a node with the given content, next node, and previous node.
     * 
     * @param nodeContent  The content of the node.
     * @param nextNode     The next node.
     * @param previousNode The previous node.
     */
    public Node(E nodeContent, Node<E> nextNode, Node<E> previousNode) {
        this.nodeContent = nodeContent;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    /**
     * Gets the content of the node.
     * 
     * @return The content of the node.
     */
    public E getContent() {
        return nodeContent;
    }

    /**
     * Gets a string representation of the content of the node.
     * 
     * @return A string representation of the content.
     */
    public String getContentString() {
        return nodeContent.toString();
    }

    /**
     * Gets the next node.
     * 
     * @return The next node.
     */
    public Node<E> getNext() {
        return nextNode;
    }

    /**
     * Gets the previous node.
     * 
     * @return The previous node.
     */
    public Node<E> getPrevious() {
        return previousNode;
    }

    /**
     * Sets the content of the node.
     * 
     * @param content The new content of the node.
     */
    public void setContent(E content) {
        this.nodeContent = content;
    }

    /**
     * Sets the next node.
     * 
     * @param next The next node.
     */
    public void setNext(Node<E> next) {
        this.nextNode = next;
    }

    /**
     * Sets the previous node.
     * 
     * @param previous The previous node.
     */
    public void setPrevious(Node<E> previous) {
        this.previousNode = previous;
    }

    /**
     * Compares this node's content to another node's content.
     * 
     * @param max The node to compare with.
     * @return A negative integer, zero, or a positive integer as this node's
     *         content is less than, equal to, or greater than the specified node's
     *         content.
     */
    public int compareTo(Node<E> max) {
        return max.getContentString().compareTo(getContentString());
    }
}
