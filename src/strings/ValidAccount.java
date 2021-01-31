package strings;

public class ValidAccount {

    public static boolean solution(String num) {


        if(num == null || num.length() == 0) return false;
        int n = num.length() - 1;
        boolean evenAlgo = true;
        if(n / 2 != 0) {
            evenAlgo = false;
        }
        int res = 0;
        for(int i = n; i >= 0; i--) {
            char ch = num.charAt(i);

            if(i%2 == 0) {
                int val = (ch - '0') * 2;
                res += sumOfDigits(val);
               // System.out.println(val);
            } else {
                res += ch - '0';
            }
        }

        System.out.println(res);
        if(res % 10 == 0) return true;


        return false;
    }

    private static int sumOfDigits(int digit) {
        int innerRes = 0;
        while(digit != 0) {
            int val = digit % 10;
            innerRes += val;
            digit = digit / 10;
        }
      //  System.out.println(innerRes);
        return innerRes;
    }


    public static void main(String[] args) {
        ValidAccount obj = new ValidAccount();

//
//        System.out.println("===================");
//        System.out.println(obj.solution("701"));
//        System.out.println("===================");
//        System.out.println(obj.solution("0"));
//        System.out.println("===================");
//        System.out.println(obj.solution("10"));
//        System.out.println("===================");
//        System.out.println(obj.solution("6866")); // 1 2 8 1 2 6 -?
        System.out.println("===================");
        System.out.println(obj.solution("299")); // 2 4 0 -> 2 1 8 9 -> 2 9 9 -> 9 + 1 + 8 + 2
        System.out.println("===================");
    }
}
