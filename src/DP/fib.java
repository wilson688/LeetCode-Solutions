package DP;

import java.util.HashMap;

public class fib {

    private static HashMap<Integer, Integer> map = new HashMap<>();
    public static int fib(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n <= 1) return 1;

        map.put(n, fib(n-1) + fib(n-2));

        return map.get(n);
    }
    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fib(40));
    }
}
