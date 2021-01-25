package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination1 {
//
//    Input: candidates = [2,3,6,7], target = 7
//    Output: [[2,2,3],[7]]
//    Explanation:
//            2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//    These are the only two combinations.
//
//    Input: candidates = [2,3,5], target = 8
//    Output: [[2,2,2,2],[2,3,3],[3,5]]
//
//    Input: candidates = [1], target = 2
//    Output: [[1,1]]

    //first start from index 0 and subtract it from the target
    //if taget > 0 then and nums[i] < target -> reuse the same index -> use the same index until it matches the target or less than target
    // else break because if the target > 0 we don't have to step futher becuase we know that the next i + 1 would be bigger than i (sorted arr)
    private static void findAllCombinations(int[] nums, int startIndex, int target, List<Integer> combinations, List<List<Integer>> result) {
        if (target == 0) {
            if(!result.contains(combinations)) {
                result.add(new ArrayList<>(combinations));
            }
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }

            combinations.add(nums[i]);
            findAllCombinations(nums, i, target - nums[i], combinations, result);
            combinations.remove(combinations.size() - 1);
        }

    }

    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();

       // Arrays.sort(nums);
        findAllCombinations(nums, 0, target, combinations, result);
        return result;
    }

    public static void main(String[] args) {
        Combination1 comb = new Combination1();
        System.out.println(comb.solution(new int[]{1,1}, 2));
        System.out.println(comb.solution(new int[]{2,3,5}, 8));
    }
}
