package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/solution/
//time complexity is O(2^N) as it is a recursive problem

public class Combinations2 {


//
//    Input: candidates = [10,1,2,7,6,1,5], target = 8
//    Output:
//            [
//            [1,1,6],
//            [1,2,5],
//            [1,7],
//            [2,6]
//            ]

//
//    Input: candidates = [2,5,2,1,2], target = 5
//    Output:
//            [
//            [1,2,2],
//            [5]
//            ]
    private static void findAllCombinations(int[] nums, int startIndex, int target, List<Integer> combinations, List<List<Integer>> result) {
        //if target == 0, then add these combinations to the result list
        // start from startIndex and iterate until you find target == 0 or sum > target
        //if target == 0, add it to the result list
        //else if target < 0 then remove the last added value from the combinations
        //if target > 0 go and grab the next index
        if(target == 0) {
            if(!result.contains(combinations)) {
                result.add(new ArrayList<>(combinations));
            }

            return;
        }

        for(int i = startIndex; i < nums.length; i++) { // 1
            if(nums[i] > target) break;

            combinations.add(nums[i]);
            findAllCombinations(nums, i + 1, target - nums[i], combinations, result);
            combinations.remove(combinations.size() - 1);

        }
    }

    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();

        Arrays.sort(nums);
        findAllCombinations(nums, 0, target, combinations, result);

        return result;
    }

    public static void main(String[] args) {
        Combinations2 comb = new Combinations2();
        System.out.println(comb.solution(new int[]{2,5,2,1,2}, 5));
        System.out.println(comb.solution(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
