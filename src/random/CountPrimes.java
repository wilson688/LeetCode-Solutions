package random;

import java.util.Arrays;

class CountPrimes {
    public int countPrimes(int n) {
        if(n < 2) return 0;

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for(int i = 2; i * i < n; i++) {
            if(primes[i]) {
                for(int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < primes.length; i++) {
            if(primes[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}