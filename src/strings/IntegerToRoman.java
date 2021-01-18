package strings;

import java.lang.*;

//leetcode question https://leetcode.com/problems/integer-to-roman/
class IntegerToRoman {

    public String solution(int num) {

        if(num == 0) return null;

        int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50,40, 10,9, 5 ,4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD","C", "XC", "L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numbers.length; i++) {
            while(num - numbers[i] >= 0) {
                sb.append(roman[i]);
                num -= numbers[i];
            }
        }


        return sb.toString();
    }

    public static void main(String args[]) {
        IntegerToRoman ir = new IntegerToRoman();
        System.out.println("===================");
        System.out.println(ir.solution(3));
        System.out.println("===================");
        System.out.println(ir.solution(4));
        System.out.println("===================");
        System.out.println(ir.solution(9));
        System.out.println("===================");
        System.out.println(ir.solution(58));
        System.out.println("===================");
        System.out.println(ir.solution(1994));
    }
}