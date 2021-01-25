package KElements;

import java.util.*;

public class TopKFrequentNumbers {

   public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       List<Integer> result = new ArrayList<>();

       for(int num: nums) {
           if(!map.containsKey(num)) {
               map.put(num, 1);
           } else {
               map.put(num, map.get(num) + 1);
           }
       }

       PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((n1, n2) -> n1.getValue() - n2.getValue());
       for(Map.Entry<Integer, Integer> mp: map.entrySet()) {
         pq.add(mp);
         if(pq.size() > k) {
             pq.poll();
         }
       }

       while(!pq.isEmpty()) {
           result.add(pq.poll().getKey());
       }

       return result;
   }



    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
