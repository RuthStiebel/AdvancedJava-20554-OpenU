public class Max {

    public static <E extends Comparable<E>> Node<E> max(LinkedList<E> list) {
        if (list.getHead() == null) {
            throw new IllegalArgumentException("List is empty");
        }
    
        Node<E> max = list.getHead();
        for (Node<E> element : list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
    
        return max;
    }
    
}
