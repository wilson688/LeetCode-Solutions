package DP;

import com.sun.tools.javadoc.Start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowSum {

    public static List<Integer> howSum(int target, int[] nums) {

        List<Integer> res = new ArrayList<>();

        return how_sum(target, nums, res);
    }

    private static List<Integer> how_sum(int target, int[] nums, List<Integer> res) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) {
            if(res.contains(target)) res.remove(target);
            return null;
        }

        for(int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];

            res.add(target);
            if(how_sum(remainder, nums, res) != null) {
                return res;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[] {5, 3 , 4 , 7}));
//        System.out.println(howSum(400, new int[] {5, 3}));
//        System.out.println(howSum(800, new int[] {5, 3}));
    }
}
