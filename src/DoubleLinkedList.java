public class DoubleLinkedList<T> {

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }


    int size = 0;
    Node<T> head = null;
    Node<T> tail = null;


    // Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {

        if(size == 0) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    //add
    public void add(T elem) {
        addLast(elem);
    }

    //remove
    public void remove() {
        removeLast();
    }

    public void removeLast() {
        if(size == 0) throw new NullPointerException();
        Node temp = tail.prev;
        tail = temp;
        tail.next = null;
        size--;
    }

    public void display() {
        Node dummy = head;
        while(dummy != null) {
            System.out.println(dummy.data);
            dummy = dummy.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();
        dl.add(10);
        dl.add(20);
        dl.add(30);
        dl.display();
        System.out.println("=====================");
        dl.remove();
        dl.display();
        System.out.println("=====================");
    }

}
