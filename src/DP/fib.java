package DP;

import java.util.Arrays;
import java.util.HashMap;

public class fib {

    private static HashMap<Integer, Integer> map = new HashMap<>();
    public static int fib(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n <= 1) return 1;

        map.put(n, fib(n-1) + fib(n-2));

        return map.get(n);
    }

    public static int fibTab(int n) {
        int[] table = new int[n+1];
        Arrays.fill(table, 0);
        table[1] = 1;


        for(int i = 2; i < table.length; i++) {
            table[i] = table[i-1] + table[i-2];
        }

        return table[n];
    }



    public static void main(String[] args) {
//        System.out.println(fib(6));
//        System.out.println(fib(8));

        System.out.println("===============");
        System.out.println(fibTab(6));
        System.out.println(fibTab(8));
    }
}
