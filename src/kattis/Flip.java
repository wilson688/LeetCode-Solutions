package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flip {

    public static int flip(int num1, int num2) {

        if(!(validate(num1) && validate(num2)))  return 0;


        int num1Reversed = flipReverse(num1);
        int num2Reversed = flipReverse(num2);

        if(!(validate(num1Reversed) && validate(num2Reversed)))  return 0;

        int result = Math.max(num1Reversed, num2Reversed);
        return result > 0 ? result : 0;
    }

    private static boolean validate(int num) {
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) return false;
        return true;
    }

    private static int flipReverse(int num) {
        int result = 0;
        while(num != 0) {
            result = result*10 +  num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while(testCases > 0) {
            String[] testValues = br.readLine().split(" ");
            int num1 = Integer.parseInt(testValues[0]);
            int num2 = Integer.parseInt(testValues[1]);
            System.out.println(flip(num1, num2));
            testCases--;
        }
    }
}
