package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Isomorphic {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, List<Character>> map = new HashMap<>();

        if(t.length() != s.length()) return false;

        for(int i = 0; i < s.length(); i++) {

            if(!validate(s.charAt(i), t.charAt(i), map) || !validate(t.charAt(i), s.charAt(i), map)) {
                return false;
            }

        }

        return true;
    }

    private static boolean validate(char ch, char ch2, Map<Character, List<Character>> map) {
        if(!map.containsKey(ch)) {
            map.put(ch, new ArrayList<Character>());
            List<Character> sList =  map.get(ch);
            sList.add(ch);
            sList.add(ch2);
            map.put(ch, sList);
        } else {
            List<Character> sList = map.get(ch);
            if(!sList.contains(ch2)) {
                if(sList.size() < 2) {
                    sList.add(ch2);
                    map.put(ch, sList);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
