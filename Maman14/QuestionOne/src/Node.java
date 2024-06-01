/**
 * A node in a linked list.
 * 
 * @param <E> The type of element stored in the node.
 */
public class Node<E> {
    private E nodeContent;
    private Node<E> nextNode;

    /**
     * Constructs a node with the given content.
     * 
     * @param nodeContent The content of the node.
     */
    public Node(E nodeContent) {
        this.nodeContent = nodeContent;
        this.nextNode = null;
    }

    /**
     * Constructs a node with the given content, next node, and previous node.
     * 
     * @param nodeContent  The content of the node.
     * @param nextNode     The next node.
     * @param previousNode The previous node.
     */
    public Node(E nodeContent, Node<E> nextNode) {
        this.nodeContent = nodeContent;
        this.nextNode = nextNode;
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
