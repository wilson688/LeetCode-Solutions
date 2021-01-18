package strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    //leetcode solution https://leetcode.com/problems/first-unique-character-in-a-string/
    public int solution1(String s) {

        Map<Character, Integer> mapIndex = new HashMap<>();
        Map<Character, Integer> mapCount = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(!mapCount.containsKey(s.charAt(i))) {
                mapCount.put(s.charAt(i), 1);
                mapIndex.put(s.charAt(i), i);
            } else mapCount.put(s.charAt(i), mapCount.get(s.charAt(i)) + 1);
        }


        int minIndex = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> mp: mapCount.entrySet()) {

            if(mp.getValue() == 1) {
                minIndex = Math.min(minIndex, mapIndex.get(mp.getKey()));
            }
        }
        if(minIndex > s.length() - 1) return -1;
        return minIndex;
    }

    public int firstUniqChar_leetcode(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(charCount[s.charAt(i) - 'a'] == 1) return i;
        }

        //O(n) -> 2n
        return -1;
    }

    public static void main(String args[]) {
        FirstUniqChar ir = new FirstUniqChar();
        System.out.println("===================");
        System.out.println(ir.solution1("lletcode"));
        System.out.println("===================");
        System.out.println(ir.solution1("missip"));
        System.out.println("===================");
        System.out.println(ir.firstUniqChar_leetcode(""));
        System.out.println("===================");
        System.out.println(ir.firstUniqChar_leetcode("loveleetcode"));
        System.out.println("===================");
        System.out.println(ir.firstUniqChar_leetcode("ever"));
    }
}
