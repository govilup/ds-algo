package com.dsalgo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 *
 * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 *
 *
 *
 * Problem Constraints
 * 0 <= B <= 105
 *
 * 1 <= size(A) <= 105
 *
 * A[i]==0 or A[i]==1
 *
 *
 *
 * Input Format
 * First argument is an binary array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1 1 0 1 1 0 0 1 1 1 ]
 *  B = 1
 * Input 2:
 *
 *  A = [1, 0, 0, 0, 1, 0, 1]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  [0, 1, 2, 3, 4]
 * Output 2:
 *
 *  [3, 4, 5, 6]
 *
 * @author govilrajput
 */

public class MaxContinuousSeriesOf1 {

    public static void main(String[] args) {
        System.out.println(maxone(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1), 1));
    }

    public static ArrayList<Integer> maxone(List<Integer> A, int B) {
        int i = 0, j = 0;

        int count = 0;
        int result = 0, currentAns = 0;
        int first = 0, last = 0;
        ArrayList<Integer> ansList = new ArrayList<>();
        int len = A.size();
        while (i <= j && j < len) {
            if (A.get(j) == 0) {
                count++;
            }
            if (A.get(j) == 1 || (A.get(j) == 0 && count <= B)) {
                currentAns++;
                if (currentAns > result) {
                    result = currentAns;
                    first = i;
                    last = j;
                }
                j++;
                continue;
            }

            if (A.get(i) == 1) {
                i++;
                currentAns--;
            } else if (A.get(i) == 0 && count > B) {
                i++;
                j++;
                count--;
            }
        }

        for(int k = first; k <= last; k++) {
            ansList.add(k);
        }

        return ansList;
    }
}
