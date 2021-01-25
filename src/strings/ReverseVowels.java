package strings;

public class ReverseVowels {

    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";

        //this time I will not use set
        char[] charString = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;
        while(start < end) {

            if(isVowel(charString[start]) && isVowel(charString[end])) {
                char temp = charString[start];
                charString[start] = charString[end];
                charString[end] = temp;
                start++;
                end--;
            } else if(!isVowel(charString[start])) {
                start++;
            } else if(!isVowel(charString[end])) {
                end--;
            }

        }

        String res = new String(charString);

     return res;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }


    public static void main(String args[]) {
        ReverseVowels ir = new ReverseVowels();
        System.out.println("===================");
        System.out.println(ir.reverseVowels("ApplE"));
        System.out.println("===================");
        System.out.println(ir.reverseVowels("road"));
        System.out.println("===================");
        //  System.out.println(ir.reverseString_usingRecursion(new char[]{}));
        System.out.println("===================");
        System.out.println(ir.reverseVowels(""));
        System.out.println("===================");
        System.out.println(ir.reverseVowels("hello"));
    }
}
