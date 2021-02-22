package strings;

public class BinaryGap {

    public int solution(int N) {
        // write your code in Java SE 8
        String binaryValue = Integer.toBinaryString(N);

        int windowStart = 0;

        while(binaryValue.charAt(windowStart) != '1') {
            windowStart++;
        }

        int windowEnd = windowStart + 1;
        int maxLength = Integer.MIN_VALUE;

        while(windowEnd < binaryValue.length()) {
            if(binaryValue.charAt(windowEnd) != '1') {
                windowEnd++;
            } else {
                maxLength = Math.max(maxLength, (windowEnd - windowStart) - 1);
                windowStart = windowEnd;
                windowEnd++;
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        //should return longest binary gap
        System.out.println(bg.solution(1041) == 5);
        System.out.println(bg.solution(529) == 4);
    }
}
