package strings;


//leetcode question link https://leetcode.com/problems/longest-common-prefix/solution/
public class LongestCommonPrefix {

    //longest common Prefix -> starting of the string (prefix)firstUniqChar

    public String solution(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        if (strs[0].length() == 0) return "";
        String catchString = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int innerLength = strs[i].length();
            int catchIndex = 0;
            String innerString = strs[i];
            int j = 0;
            while (j < catchString.length() && j < innerString.length() && innerString.charAt(j) == catchString.charAt(j)) {
                j++;
            }

            if (j == 0) return "";
            catchString = catchString.substring(0, j);

        }


        return catchString;
    }

    public static void main(String args[]) {
        LongestCommonPrefix ir = new LongestCommonPrefix();
        System.out.println("===================");
        System.out.println(ir.solution(new String[]{"flower","flow","flight"}));
        System.out.println("===================");
        System.out.println(ir.solution(new String[]{"dog","racecar","car"}));
        System.out.println("===================");
        System.out.println(ir.solution(new String[]{"cat","dog"}));
        System.out.println("===================");
        System.out.println(ir.solution(new String[]{"water", "wall"}));
        System.out.println("===================");
        System.out.println(ir.solution(new String[]{"aaa","aa","aaa"}));
    }
}
