package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MagicalCows {

    static int solveMagicCow(List<Integer> cows, int day, int farms) {
        if(cows == null || cows.size() == 0) return 0;
        if(day == 0) return farms;
        int totalCows = 0;
        for(Integer cow: cows) {
            totalCows += cow;
        }
        return solveRecursive(totalCows, 0, day);
    }

    static int solveRecursive(int totalCows, int currDay, int days) {

        if(currDay != 1) {
            totalCows = totalCows*2;
        }

        if(days == 1 || currDay >= days) return totalCows;


        return solveRecursive(totalCows, currDay+ 1, days);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        // The maximum number of cows on a farm
        final int C = Integer.parseInt(line[0]);

        // The initial number of farms
        final int N = Integer.parseInt(line[1]);

        // The number of queries
        final int M = Integer.parseInt(line[2]);

        List<Integer> cows = new ArrayList<>();
        // Count the initial frequency of farms of different sizes
        for (int i = 0; i < N; i++) {
            cows.add(Integer.parseInt(br.readLine()));
        }

        System.out.println();
        System.out.println("No. of farms on day 0 is " + solveMagicCow(cows, 0, N));
        System.out.println("No. of farms on day 1 is " + solveMagicCow(cows, 1, N));
        System.out.println("No. of farms on day 2 is " + solveMagicCow(cows, 2, N));
        System.out.println("No. of farms on day 3 is " + solveMagicCow(cows, 3, N));
        System.out.println("No. of farms on day 4 is " + solveMagicCow(cows, 4, N));
    }
}