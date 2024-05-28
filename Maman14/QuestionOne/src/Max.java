public class Max {

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
