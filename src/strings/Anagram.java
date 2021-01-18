package strings;

public class Anagram {

//    what is an Anagram?
//    Ans. String t is said to be anagram of s if t contains all the characters of s
//         and length of t and s should be equal

//leetcode question: https://leetcode.com/problems/valid-anagram/
    public boolean isAnagram_withforloops(String s, String t) {
        if(s.length() < t.length()) return false;

        int[] charCountS = new int[26];
        int[] charCountT = new int[26];

        for(int i = 0; i < s.length(); i++) {
            charCountS[s.charAt(i) - 'a']++;
        }


        for(int i = 0; i < t.length(); i++) {
            charCountT[t.charAt(i) - 'a']++;
        }

        for(int j = 0; j < s.length(); j++) {
            if(charCountS[s.charAt(j) - 'a'] != charCountT[s.charAt(j) - 'a']) return false;
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] counter = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int count: counter) {
            if(count != 0) return false;
        }


        return true;
    }

    public static void main(String args[]) {
        Anagram obj = new Anagram();
        System.out.println("===================");
        System.out.println(obj.isAnagram("anagram","nagaram"));
        System.out.println("===================");
        System.out.println(obj.isAnagram("cat","rat"));
        System.out.println("===================");
        System.out.println(obj.isAnagram("a","nagaram"));
        System.out.println("===================");
        System.out.println(obj.isAnagram("a","ab"));
    }
}
