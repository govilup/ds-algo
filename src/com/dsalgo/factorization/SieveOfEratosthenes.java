package com.dsalgo.factorization;

/**
 * 1) Assume everything is prime.
 * 2) Mark off 0 and 1 as non prime.
 * 3) Mark next element which is not already marked as prime.
 * 4) Remove all multiples of that number.
 */
public class SieveOfEratosthenes {

    private static final int MAX = 1000000;
    private static final boolean[] primes = new boolean[MAX + 1];

    private static final int[] count = new int[MAX + 1];

    public static int[] sieve() {

        for(int i = 0; i <= MAX; i++) {
            if(i == 0 || i == 1) {
                continue;
            }
            primes[i] = true;
        }

        for(int p = 2; p <= MAX; p++) {
            if (primes[p]) {
                for (int j = p * 2; j <= MAX; j += p) {
                    if (primes[j]) {
                        primes[j] = false;
                        count[p]++;
                    }
                }
            }
        }
        return count;
    }

}
