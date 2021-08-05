package com.dsalgo.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intersection Of Sorted Arrays
 * Problem Description
 * <p>
 * Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.
 * <p>
 * Example:
 * <p>
 * Input:
 * A: [1 2 3 3 4 5 6]
 * B: [3 3 5]
 * <p>
 * Output: [3 3 5]
 * <p>
 * Input:
 * A: [1 2 3 3 4 5 6]
 * B: [3 5]
 * <p>
 * Output: [3 5]
 *
 * @author govilrajput
 */
public class FindIntersection {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101));
        List<Integer> B = new ArrayList<>(Arrays.asList(5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98));
        System.out.println(intersect(A, B));
    }

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

        int i = 0, j = 0;

        int A_size = A.size();
        int B_size = B.size();

        if (A_size == 0 && B_size > 0) {
            return new ArrayList<>(B);
        }

        if (B_size == 0 && A_size > 0) {
            return new ArrayList<>(A);
        }

        ArrayList<Integer> ansList = new ArrayList<>();
        while (i < A_size && j < B_size) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                ansList.add(A.get(i));
                j++;
                i++;
            }
        }
        return ansList;
    }
}
