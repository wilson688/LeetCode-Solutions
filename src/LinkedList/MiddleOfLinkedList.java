package LinkedList;

import java.util.*;

class MiddleOfLinkedList {

    public static ListNode findMiddle(ListNode head) {
        // TODO: Write your code here

        //find the middle node
        //first iterate and grab the references of each node into an array and it's index value
        //find the length of the list while iterating
        //do the math for middle node
        //grab it's value and use it against map to grab the reference

        ListNode dummy = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while(dummy != null) {
            if(!map.containsKey(index)) {
                map.put(index++, dummy);
            }

            dummy = dummy.next;
        }

        int middleIndex = 0;
        if(index % 2 == 0) {
            middleIndex = index / 2;
        } else {
            middleIndex = (index - 1)/ 2;
        }


        return map.get(middleIndex);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).val);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).val);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).val);
    }
}