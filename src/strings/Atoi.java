package strings;
public class Atoi {

    //leetcode solution https://leetcode.com/problems/string-to-integer-atoi/

    public int solution(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int len = s.length();
        double result = 0;

        //set negative to false
        boolean isNegative = false;

        int startIndex = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            startIndex++;
        }

        if(s.charAt(0) == '-') {
            isNegative = true;
        }

        for(int i = startIndex; i < len; i++ ) {
            //if first chars are words or special chars other than '-' or '+'
            if(s.charAt(i) < '0' || s.charAt(i) > '9') break;

            int digit = (int) s.charAt(i) - '0';
            result = result * 10 + digit;
        }

        if(isNegative) result = -result;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }


    public static void main(String args[]) {
        Atoi atoi = new Atoi();
        System.out.println("===================");
        System.out.println(atoi.solution("   1 23  "));
        System.out.println("===================");
        System.out.println(atoi.solution("-123"));
        System.out.println("===================");
        System.out.println(atoi.solution("123@%^123"));
        System.out.println("===================");
        System.out.println(atoi.solution("99998888777766665555444433"));
    }
}
