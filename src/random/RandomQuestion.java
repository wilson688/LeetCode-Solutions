package random;

public class RandomQuestion {

    public static int findMinSubArray(int S, int[] arr) {

        int maxLength = Integer.MAX_VALUE;

        int windowStart = 0;

        int sum = 0;


        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            while(sum >= S) {
               maxLength = Math.min(maxLength, (windowEnd - windowStart) + 1);
               sum -= arr[windowStart++];
            }
        }

        return maxLength == Integer.MAX_VALUE? 0 : maxLength;
    }


    public static void main(String args[]) {
        int[] values = new int[] {3, 4, 1, 1, 8};
        int[] values2 = new int[] { 2, 1, 5, 1, 3, 2 };
        int S = 8;
        System.out.println(findMinSubArray(S, values));
        System.out.println(findMinSubArray(7, values2));
    }
}
