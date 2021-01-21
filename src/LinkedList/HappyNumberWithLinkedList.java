package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberWithLinkedList {

    public static boolean solution(int num) {
        if(num == 0) return false;

        int fast = num;
        int slow = num;

        while(fast != slow) {
            fast = findSumOfSquares(findSumOfSquares(num));
            slow = findSumOfSquares(num);
        }

      return slow == 1? true: false;
    }

    private static int findSumOfSquares(int num) {
        int digit1 = num / 10;
        int digit2 = num % 10;
        int sum = digit1*digit1 + digit2*digit2;


        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
