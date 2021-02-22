package arrays;

public class MinMovesToEqualArray {

    public int minMoves(int[] nums) {

    // a function to increment all the elements until all elements are equal
        // a validate method to check if all the elements are equal
        //a counter to check how many times we have incremented the array
        // a pointer to check how many elements we have changed for each iterations and make sure it is always less than n - 1
                int moves = 0, min = Integer.MAX_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    moves += nums[i];
                    min = Math.min(min, nums[i]);
                }
                return moves - min * nums.length;

    }


    public static void main(String[] args) {
        MinMovesToEqualArray ma = new MinMovesToEqualArray();

        System.out.println(ma.minMoves(new int[] {1, 2, 3}));
        System.out.println(ma.minMoves(new int[] {1, 2, 3, 4}));
        System.out.println(ma.minMoves(new int[] {1, 2}));
        System.out.println(ma.minMoves(new int[] {1, 3}));
        System.out.println(ma.minMoves(new int[] {1, 2, 3, 4 , 5, 6}));
    }
}
