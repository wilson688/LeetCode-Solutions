package arrays;

public class ContainsDuplicates2 {

    public static boolean hasDuplicates(int[] nums, int k) {

        if(nums == null || nums.length == 0) return false;

        for(int i = 0; i < nums.length; i++) {
            if(i + k <= nums.length -1 && nums[i] == nums[i+k]) {
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {

        System.out.println(hasDuplicates(new int[] {1,2,3,1}, 3));;
        System.out.println(hasDuplicates(new int[] {1,0,1,1}, 1));;
    }
}
