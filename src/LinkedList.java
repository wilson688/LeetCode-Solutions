//linkedlist?????
//of a datastructure
// int val; node next;



public class LinkedList<T> {

   public class Node<T> {
       T data;
       Node next = null;

       public Node(T data) {
           this.data = data;
           this.next = null;
       }
   }

   Node head = null;
   Node tail = null;

   public void add(T data) {
       //create a new node
       Node newNode = new Node(data);

       //check if list is empty
       if(head == null) {
           head = newNode;
           tail = newNode;
       } else {
           tail.next = newNode;
           tail = tail.next;
       }
   }

   public void display() {
       Node dummy = head;
       while(dummy != null) {
           System.out.println(dummy.data);
           dummy = dummy.next;
       }
   }

    //add element to list
    public static void main(String[] args) {
       LinkedList<Integer> lst = new LinkedList<>();
       lst.add(10);
       lst.add(20);
       lst.add(30);
       lst.display();
       System.out.println("=====================");
       lst.add(90);
       lst.add(80);
       lst.add(70);
       lst.display();
       System.out.println("=====================");
    }



}
