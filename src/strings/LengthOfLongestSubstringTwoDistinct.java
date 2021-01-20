package strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstringTwoDistinct {
    public int solution(String s) {
        if (s == null || s.length() == 0) return 0;

        int k = 0;
        int windowStart = 0;
        Map<Character, Integer> list = new HashMap<>();
        int windowEnd = 0; //eceba
        int maxLength = 0;

        while(windowEnd < s.length()) {
            list.put(s.charAt(windowEnd), windowEnd++);

            if(list.size() == 3) {
                int del_idx = Collections.min(list.values());
                list.remove(s.charAt(del_idx));
                windowStart = del_idx + 1;
            }
            maxLength = Math.max(windowEnd - windowStart, maxLength);
        }

        return maxLength;

    }
}