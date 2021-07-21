package com.dsalgo.sorting;

import static com.dsalgo.sorting.MergeSortAlgo.mergeSort;

/**
 * Problem Description
 *
 * Given an array of integers A of size N where N is even.
 *
 * Divide the array into two subsets such that
 *
 * 1.Length of both subset is equal.
 * 2.Each element of A occurs in exactly one of these subset.
 * Magic number = sum of absolute difference of corresponding elements of subset.
 *
 * Note: You can reorder the position of elements within the subset to find the value of magic number.
 *
 * For Ex:-
 * subset 1 = {1, 5, 1},
 * subset 2 = {1, 7, 11}
 * Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
 * Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
 */
public class MaxAndMinMagic {

    public int[] solve(int[] A) {

        int len = A.length;

        int[] sortedArr = mergeSort(A, 0, len - 1);

        int min = 0, max = 0, mod = 1000 * 1000 * 1000 + 7;

        for(int i = 0; i < sortedArr.length - 1; i += 2) {
            min += Math.abs(sortedArr[i] - sortedArr[i+1]) % mod;
            min = min % mod;
        }

        for(int i = 0; i < (len / 2); i++) {
            max += Math.abs(sortedArr[i] - sortedArr[len - 1 - i]) % mod;
            max = max % mod;
        }

        int[] ansArr = new int[2];
        ansArr[0] = max;
        ansArr[1] = min;

        return ansArr;
    }

}
