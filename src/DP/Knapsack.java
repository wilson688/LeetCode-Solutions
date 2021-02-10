package DP;

public class Knapsack {

   public int solveKnapsack2(int[] profits, int[] weights, int capacity) {
       int[][] dp = new int[profits.length][capacity+1];
       return knapsackRecursive(dp, profits, weights, capacity, 0);
   }


   private int knapsackRecursive(int[][] dp, int[] profits, int[] weights, int capacity, int currIndex) {

     if(capacity <= 0 || currIndex >= profits.length) return 0;
     if(dp[currIndex][capacity] != 0) return dp[currIndex][capacity];
     int profit1 = 0;
     if(weights[currIndex] <= capacity) {
         profit1 = profits[currIndex] + knapsackRecursive(dp,profits, weights, capacity - weights[currIndex], currIndex + 1);
     }
     int profit2 = knapsackRecursive(dp,profits, weights, capacity, currIndex + 1);

       dp[currIndex][capacity] = Math.max(profit1, profit2);
     return dp[currIndex][capacity];
   }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for(int i=0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for(int i=1; i < n; i++) {
            for(int c=1; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                // exclude the item
                profit2 = dp[i-1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        // maximum profit will be at the bottom-right corner.
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
