### FAST AND SLOW POINTER 
Flyod's fast and slow pointer 
- helps identify cycles in the linkedlist
- helps find the middle number in a linkedlist 
```
ListNode fast = head; 
ListNode slow = head; 

while(fast != null && fast.next != null) {
   fast = fast.next.next; 
   slow = slow.next; 
   
   if(fast == slow) return true; //cyclic detected 
 }
```

### 