/**
 * A utility class to find the maximum element in a linked list.
 */
public class Max {

    /**
     * Finds and returns the node containing the maximum element in the linked list.
     * 
     * @param <E>  The type of elements in the linked list.
     * @param list The linked list to search for the maximum element.
     * @return The node containing the maximum element.
     * @throws IllegalArgumentException If the list is empty.
     */
    public static <E extends Comparable<E>> Node<E> max(LinkedList<E> list) {
        if (list.getHead() == null) {
            throw new IllegalArgumentException("List is empty");
        }

        Node<E> max = list.getHead();
        Node<E> element = list.getHead();
        while (element != null) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
            element = element.getNext();
        }
        return max;
    }

}
