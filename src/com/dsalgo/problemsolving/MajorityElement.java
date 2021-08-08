package com.dsalgo.problemsolving;

import java.util.Arrays;
import java.util.List;

/**
 * N/3 Repeat Number
 * Problem Description
 * <p>
 * You're given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 * <p>
 * If there are multiple solutions, return any one.
 * <p>
 * Example:
 * <p>
 * Input: [1 2 3 1 1]
 * Output: 1
 * 1 occurs 3 times which is more than 5/3 times.
 */
public class MajorityElement {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 1, 1, 2, 3, 5, 7);
        System.out.println(repeatedNumber(A));
    }

    public static int repeatedNumber(final List<Integer> A) {
/*	    Map<Integer, Integer> map = new HashMap<>();

	    for(Integer num : A) {
	        map.put(num, map.getOrDefault(num, 0) + 1);
	        if(map.get(num) > n_3) {
	            return num;
	        }
	    }*/

        int candidateForME = findCandidate(A);

        if (isMajorityElement(candidateForME, A)) {
            return candidateForME;
        }

        return -1;
    }

    //Moore's Voting Algo
    private static int findCandidate(List<Integer> A) {
        int maj_idx = 0;
        int count = 1;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).equals(A.get(maj_idx))) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maj_idx = i;
                count = 1;
            }
        }
        return A.get(maj_idx);
    }

    private static boolean isMajorityElement(int candidateForME, List<Integer> A) {
        int n_3 = A.size() / 3;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == candidateForME) {
                count++;
            }
        }

        return count > n_3;
    }

}
