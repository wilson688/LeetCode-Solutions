package matrix;

import java.util.HashMap;

public class GridTraveler {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static int gridTraveler(int m, int n) {
        String key = m + "," + n;
        if(map.containsKey(key)) return map.get(key);
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;

        map.put(key, gridTraveler(m -1, n) + gridTraveler(m, n - 1));

        return map.get(key);
    }


    public static void main(String[] args) {
//        System.out.println(gridTraveler(1, 1)); // 1
//        System.out.println(gridTraveler(3,3)); //
//        System.out.println(gridTraveler(2, 3)); // 3
//        System.out.println(gridTraveler(0, 1)); // 0
        System.out.println(gridTraveler(18, 18)); // 0
    }
}
