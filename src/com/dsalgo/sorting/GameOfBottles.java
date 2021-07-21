package com.dsalgo.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 *
 * Given an array of integers A of size N which denotes N cylindrical empty bottles. The radius of the ith bottle is A[i].
 * You can put the ith bottle into the jth bottle if the following conditions are met:
 *
 * ith bottle is not put into another bottle.
 * jth bottle dosen't contain any other bottle.
 * The radius of bottle i is smaller than bottle j (A[i] < A[j]).
 * You can put bottles into each other any number of times. You want to MINIMIZE the number of visible bottles. A bottle is called visible if it is not put into any other bottle.
 *
 * Find and return the minimum number of visible bottles.
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3]
 * Input 2:
 *
 * A = [1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  In example 1 it is possible to put bottle 1 into bottle 2, and 2 into 3.
 * Explanation 2:
 *
 *  Both bottles will be visible.
 */
public class GameOfBottles {

    public static void main(String[] args) {
        int[] A = new int[] {8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3, 8, 17, 12, 5, 3, 14, 13, 3, 2, 17, 19, 16, 8, 7, 12, 19, 10, 13, 8, 20, 16, 15, 4, 12, 3};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {

        int len = A.length;
        if(len < 2) {
            return 1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = map.values().stream().max(Comparator.naturalOrder()).get();

        return max;

/*        int[] sortedArr = MergeSortAlgo.mergeSort(A, 0, len - 1);

        int count = 1;
        for(int i = 0; i < len - 1; i++) {
            if(sortedArr[i] < sortedArr[i+1]) {
                continue;
            } else {
                count++;
            }
        }
        return count;*/
    }

}
