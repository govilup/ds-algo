package com.dsalgo.searching;

import com.dsalgo.factorization.EuclidsAlgo;

/**
 * Ath Magical Number
 * Problem Description
 * <p>
 * Given three positive integers A, B and C.
 * <p>
 * Any positive integer is magical if it is divisible by either B or C.
 * <p>
 * Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 109
 * <p>
 * 2 <= B, C <= 40000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A.
 * <p>
 * The second argument given is an integer B.
 * <p>
 * The third argument given is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * A = 4
 * B = 2
 * C = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1st magical number is 2.
 * Explanation 2:
 * <p>
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 *
 * @author govilrajput
 */
public class NthMagicalNumber {

    public static void main(String[] args) {
        System.out.println(solve(19, 11, 13));
    }

    public static int solve(int A, int B, int C) {
        int low = 1, high = Math.min(B, C) * A;

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (inRange(mid, B, C, A)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans % (1000 * 1000 * 1000 + 7);
    }

    public static boolean inRange(int x, int B, int C, int A) {
        int isAns = (x / B) + (x / C) - (x / (lcm(B, C)));
        return isAns >= A;
    }

    public static int lcm(int B, int C) {
        return (B * C) / EuclidsAlgo.gcd(B, C);
    }
}
