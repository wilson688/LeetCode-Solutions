package strings;

import java.util.*;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0) return null;

        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        String[] words = normalizedStr.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        List<String> bannedWords = Arrays.asList(banned);

        for(int i =0; i < words.length; i++) {
            String currWord = words[i];
            if(!bannedWords.contains(currWord)) {
                if(!map.containsKey(currWord)) {
                    map.put(currWord, 1);
                } else {
                    map.put(currWord, map.getOrDefault(currWord, 0) + 1);
                }
            }

        }

        Integer commonWordCount = Collections.min(map.values(), Collections.reverseOrder());

        for(Map.Entry<String,Integer> mp: map.entrySet()) {
            if(mp.getValue() == commonWordCount) return mp.getKey();
        }

        return null;
    }
}