package arrays;

import java.util.List;
//https://leetcode.com/problems/maximum-distance-in-arrays/
class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int secondMin = min;
        int max = Integer.MIN_VALUE;
        int secondMax = max;
        boolean flag = false;
        for(int i = arrays.size() - 1; i >= 0; i--) {
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(arrays.get(i).size() - 1);
            if(curMin < min && curMax > max) {
                flag = true;
            } else if(curMin < min || curMax > max) {
                flag = false;
            }
            if(curMin < min) {
                secondMin = min;
                min = curMin;
            } else if(curMin < secondMin) {
                secondMin = curMin;
            }
            if(curMax > max) {
                secondMax = max;
                max = curMax;
            } else if(curMax > secondMax) {
                secondMax = curMax;
            }
        }
        return flag ? (Math.max(max - secondMin, secondMax - min)) : (max - min);
    }
}