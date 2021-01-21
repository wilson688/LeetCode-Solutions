package LinkedList;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode listA = headA;
        ListNode listB = headB;

        while(listA != listB) {
            listA = listA.next;
            listB = listB.next;

            if(listA == listB) {
                return listA;
            }

            if(listA == null) {
                listA = headB;
            }

            if(listB == null) {
                listB = headA;
            }
        }

        return listA;
    }
}