package com.dsalgo.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Perfect Numbers
 * Problem Description
 * <p>
 * Given an integer A, you have to find the Ath Perfect Number.
 * <p>
 * A Perfect Number has the following properties:
 * <p>
 * It comprises only 1 and 2.
 * <p>
 * The number of digits in a Perfect number is even.
 * <p>
 * It is a palindrome number.
 * <p>
 * For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 22
 * Output 2:
 * <p>
 * 1111
 */
public class AthPerfectNumber {

    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    public static String solve(int A) {
        Queue<String> queue = new LinkedList<>();

        queue.add("1");
        queue.add("2");

        String perfectNumber = null;
        int i = 1;
        while (i <= A) {
            String temp = queue.remove();
            perfectNumber = generatePerfectNumber(temp);
            queue.add(temp + "1");
            queue.add(temp + "2");
            i++;
        }
        return perfectNumber;
    }

    public static String generatePerfectNumber(String number) {
        String reverse = new StringBuilder(number).reverse().toString();

        return number + reverse;
    }
}
