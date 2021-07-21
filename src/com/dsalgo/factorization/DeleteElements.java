package com.dsalgo.factorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array A of size N.
 * Find the minimum number of elements that need to be removed such that the GCD of the resulting array becomes 1.
 *
 * If not possible then return -1.
 *
 * Input 1:
 *  A = [7, 2, 5]
 *
 * Output 1:
 *  0
 */
public class DeleteElements {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(7, 2, 5));
        System.out.print(deleteElements(A));
    }

    private static int deleteElements(List<Integer> A) {
        int gcd = 0;
        for(int i = 0; i < A.size(); i++) {
            gcd = EuclidsAlgo.gcd(A.get(i), gcd);
        }
        return gcd == 1 ? 0 : -1;
    }
}
