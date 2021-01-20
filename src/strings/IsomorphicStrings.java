package strings;

//question - https://leetcode.com/problems/isomorphic-strings/

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        for(int i = 0;i<s.length();i++){
            String ss = String.valueOf(s.charAt(i));
            String tt = String.valueOf(t.charAt(i));

            int si = s.indexOf(ss);
            int ti = t.indexOf(tt);

            if(si!= ti) return false;
        }

        return true;
    }
}