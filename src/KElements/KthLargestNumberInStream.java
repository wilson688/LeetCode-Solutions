package KElements;

import java.util.*;

class KthLargestNumberInStream {

    PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n1 - n2);
    final int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        // TODO: Write your code here
        this.k = k;
        // add the numbers in the min heap
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int num) {
        // TODO: Write your code here
        pq.add(num);

        // if heap has more than 'k' numbers, remove one number
        if (pq.size() > this.k)
            pq.poll();

        // return the 'Kth largest number
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}