package com.dsalgo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * <p>
 * Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.
 * <p>
 * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * Output Format
 * Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2]
 * B = 5
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
 * Explanation 2:
 * <p>
 * No Rectangle is valid.
 */
public class CountRectangleConfig {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(8, 15, 19, 21, 26, 30, 45, 48, 59, 66, 67, 72, 134, 143, 152, 174, 182, 185, 201, 207, 229, 234, 250, 253, 261, 303, 306, 312, 330, 359, 382, 385, 398, 427, 439, 442, 443, 455, 457, 484, 491));
        System.out.println(solve(A, 902));
    }

    public static int solve(List<Integer> A, int B) {
        int len = A.size();
        if (len == 1 && A.get(0) * A.get(0) < B) {
            return 1;
        }

        int i = 0, j = len - 1;
        int mod = 1000 * 1000 * 1000 + 7;

        long count = 0;
        while (i <= j) {
            long area = ((long) A.get(i) * A.get(j));
            if (area < B) {
                int configurations = j - i;
                count = (count + (2 * configurations) + 1) % mod;
                i++;
            } else {
                j--;
            }
        }

        return (int) (count % mod);
    }
}
