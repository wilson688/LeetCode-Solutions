package strings;

public class CountAndSaySimpleSolution {

    //leetcode q link https://leetcode.com/problems/count-and-say/

    public String solution(int n) {
        if(n == 1) return "1";
        String result = "1";
        for(int i = 2; i < n; i++) {
            result = count(result);
        }

        return result;
    }

    public String count(String s) {
        StringBuilder sb = new StringBuilder();

        //grab the first char
        char ch = s.charAt(0);
        int count = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != ch) {
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            } else {
                count += 1;
            }
        }

        sb.append(count).append(ch);

        return sb.toString();
    }


    public static void main(String args[]) {
        CountAndSaySimpleSolution obj = new CountAndSaySimpleSolution();
        System.out.println("===================");
        System.out.println(obj.solution(3));
        System.out.println("===================");
        System.out.println(obj.solution(4));
        System.out.println("===================");
        System.out.println(obj.solution(9));
        System.out.println("===================");
        System.out.println(obj.solution(8));
        System.out.println("===================");
        System.out.println(obj.solution(10));
    }
}
