package com.dsalgo.factorization;

/**
 * Problem Description
 *
 * You are given a Task as described below :
 * You are given A queries. For each query (1<=i<=A) you are given a prime number B[i],
 * you need to give the count of all numbers in range 1 to 10^6 inclusive which have
 * minimum prime factor B[i] for each query.
 *
 */
public class CountNumbersPrimeFactor {

    //Apply Sieve of Eratosthenes
    SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();

    public static void main(String[] args) {
        int[] count = SieveOfEratosthenes.sieve();
        System.out.print(count[8] + 1);
    }
}
