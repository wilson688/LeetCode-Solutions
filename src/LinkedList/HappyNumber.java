package LinkedList;

import java.util.*;
class HappyNumber {

    public static boolean find(int num) {
        // // TODO: Write your code here

        //other than linkedlist

        if(num == 0) return false;
        //first set is to get the sum of square
        //second is to put it in map
        //next time if it gets the same number break the cycle of finding sqares
        // and check if the number == 1? true : false
        int duplicateNumber = findSumOfSquares(num);

        return duplicateNumber == 1? true: false;
    }


    private static int findSumOfSquares(int num) {
        Set<Integer> set = new HashSet<>();

        while(num != 0) {
            int digit1 = num / 10;
            int digit2 = num % 10;
            int sum = digit1*digit1 + digit2*digit2;
            if(set.contains(sum)) return sum;
            set.add(sum);
            num = sum;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}