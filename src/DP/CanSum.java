package DP;

import java.util.Arrays;
import java.util.HashMap;

public class CanSum {

    private static HashMap<Integer, Boolean> map = new HashMap<>();
    public static boolean canSum(int target, int[] nums) {

        if(map.containsKey(target)) return map.get(target);
        if(target == 0) return true;
        if(target < 0) return false;

        for(int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if(canSum(remainder, Arrays.copyOfRange(nums,i, nums.length -1)) == true) {
                map.put(target, true);
                return true;
            }
        }

        map.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] {5, 3 , 4 , 7}));
        System.out.println(canSum(400, new int[] {5, 3}));
        System.out.println(canSum(800, new int[] {5, 3}));
    }
}
