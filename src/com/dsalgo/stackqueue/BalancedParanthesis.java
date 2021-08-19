package com.dsalgo.stackqueue;

import java.util.Stack;

/**
 * Problem Description
 * <p>
 * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 * <p>
 * Refer to the examples for more clarity.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains the string A having the paranthesis sequence.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 0, if the paranthesis sequence is not balanced.
 * <p>
 * Return 1, if the paranthesis sequence is balanced.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = {([])}
 * Input 2:
 * <p>
 * A = (){
 * Input 3:
 * <p>
 * A = ()[]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * Output 3:
 * <p>
 * 1
 *
 * @author govilrajput
 */
public class BalancedParanthesis {

    public static void main(String[] args) {
        System.out.println(solve("({)}"));
    }

    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(A.charAt(i));
                continue;
            }

            if (stack.isEmpty()) {
                return 0;
            }

            char check;
            switch (ch) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return 0;
                    }
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return 0;
                    }
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{') {
                        return 0;
                    }
                    break;
            }

        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
