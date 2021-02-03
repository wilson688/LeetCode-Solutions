package LinkedList;

public class RemoveLinkedListElements {


    public static ListNode removeElement(ListNode head, int key) {


        //you would need a copy of head to return it in the end
        ListNode headCopy = head;

        ListNode prev = null;


        while(head.next != null) {
            //grab the curr val
            // and check if that's value is given to given value
            //if yes replace it with the next ListNode
            if(head.val == key) {
                ListNode temp = head.next;
                head = prev;
                head.next = temp;
            } else prev = head;


            head = head.next;

        }

        return headCopy;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("New List: " + removeElement(head, 3));

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("New List: " + removeElement(head, 4));

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("New List: " + removeElement(head, 2));
    }
}
