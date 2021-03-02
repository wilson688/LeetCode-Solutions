package arrays;

import java.util.ArrayList;
import java.util.List;

public class ValidSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.

        int sizeI = array.size();
        int sizeJ = sequence.size();
        int i = 0;
        int j = 0;

        while(i < sizeI && j < sizeJ) {
            if(array.get(i) != sequence.get(j)) {
                i++;
            } else {
                i++;
                j++;
            }
        }

        if(i == sizeI - 1 && j == sizeJ - 1) return true;
        if(i == sizeI && j < sizeJ) return false;


        return true;
    }


    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(1);
        array.add(22);
        array.add(25);array.add(6);array.add(-1);array.add(8);array.add(10);
        List<Integer> seq = new ArrayList<>();
        seq.add(5);
        seq.add(1);seq.add(22);seq.add(25);seq.add(6);seq.add(-1);seq.add(8);seq.add(10);seq.add(12);


        System.out.println(isValidSubsequence(array, seq));;
    }
}
