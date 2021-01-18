package strings;

//leetcode question https://leetcode.com/problems/reverse-string/submissions/
public class ReverseString {
    public char[] reverseStringSolution(char[] s) {

        if(s == null || s.length == 0) return null;

        for(int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

        }
//O(n) -> n
        return s;

    }

    public char[] reverseString_usingRecursion(char[] s) {

        if(s == null || s.length == 0) return null;

        return reverseStringUsingRecursion(0, s.length - 1, s);

    }

    private char[] reverseStringUsingRecursion(int low, int high, char[] s) {
        if(low > high) return null;

        char temp = s[low];
        s[low] = s[high];
        s[high] = temp;

        reverseStringUsingRecursion(++low, --high, s);
        return s;
    }

    public static void main(String args[]) {
        ReverseString ir = new ReverseString();
        System.out.println("===================");
        System.out.println(ir.reverseStringSolution("lletcode".toCharArray()));
        System.out.println("===================");
        System.out.println(ir.reverseString_usingRecursion("missip".toCharArray()));
        System.out.println("===================");
      //  System.out.println(ir.reverseString_usingRecursion(new char[]{}));
        System.out.println("===================");
        System.out.println(ir.reverseString_usingRecursion("loveleetcode".toCharArray()));
        System.out.println("===================");
        System.out.println(ir.reverseStringSolution("ever".toCharArray()));
    }
}
