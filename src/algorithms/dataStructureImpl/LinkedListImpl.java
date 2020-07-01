package algorithms.dataStructureImpl;

public class LinkedListImpl<E> {

    Node first;

    class Node<E> {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
            next = null;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    //add a node to the linkedlist, the node must be linked by previous node.
    //so once the item is added as a node, return this node for parent to link
    public void add(E item) {
        Node node = new Node(item);
        first = addNode(first, node);
    }

    Node addNode(Node x, Node node) {
        if (x == null) {
            x = node;
        } else {
            x.next = addNode(x.next, node);
        }
        return x;
    }

    /**
     * in-place reverse.
     */
    public void reverse() {
        Node prev = null, current = first, next;
        if (current == null) return;

        next = first.next;
        while (true) {
            current.next = prev;
            if (next == null) {
                break;
            }
            prev = current;
            current = next;
            next = next.next;
        }
        first = current;
    }

    /**
     * use three pointers
     */
    public void deleteAlternative() {
        Node current, next, nextAfterNext;
        current = first;
        while (current != null && current.next != null) {
            next = current.next;
            nextAfterNext = next.next;
            current.next = nextAfterNext;

            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node x = first;
        while (x != null) {
            sb.append(x).append(" ");
            x = x.next;
        }
        return sb.toString();
    }


    //unit testing
    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        list.deleteAlternative();
        System.out.println(list);
    }
}


