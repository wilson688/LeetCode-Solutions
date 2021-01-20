package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagram {
    public List<List<String>> solution(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList();

        List<List<String>> result = new ArrayList<>();


        Map<String, List> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String count = sumOfChars(strs[i]);
            if(!map.containsKey(count)) map.put(count, new ArrayList());
            map.get(count).add(strs[i]);
        }



        return new ArrayList(map.values());
    }


    private String sumOfChars(String s) {
        char[] arr = new char[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        return new String(arr);

    }

    public static void main(String args[]) {
        GroupAnagram obj = new GroupAnagram();
        System.out.println("===================");
        System.out.println(obj.solution(
                new String[]{"eat","tea","tan","ate","nat","bat"}));

    }
}

