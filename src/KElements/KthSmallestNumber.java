package KElements;

import java.util.*;

class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        // TODO: Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] < pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
