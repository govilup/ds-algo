package com.dsalgo.stringalgo;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ZAlgorithm {

    public static void main(String[] args) {
//        String B = "1001";
//        B = B + B;
//        System.out.println(B);
//        System.out.println(B.substring(0, B.length() - 1));
        Deque<String> stack = new LinkedList<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack);
        System.out.println(stack.removeLast());
        //System.out.println(Arrays.toString(z_algo_optimised("bbbb")));
    }

    /**
     * Brute Force
     * TC: O(n^2)
     * @param string
     * @return z array;
     */
    public static int[] z_algo(String s) {
        int n = s.length();
        int[] z = new int[n];

        z[0] = 0;
        for(int i = 1; i < n; i++) {
            int j = 0;
            while(i + j < n && s.charAt(i + j) == s.charAt(j)) {
                j++;
            }
            z[i] = j;
        }
        return z;
    }

    public static int[] z_algo_optimised(String s) {
        int n = s.length();
        int[] z = new int[n];

        z[0] = 0;

        int l = 0, r = 0;

        for(int i = 1; i < n; i++) {
            if(i > r) {
                //brute force
                l = r = i;
                while(r < n && s.charAt(r) == s.charAt(r - l)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if(z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while(r < n && s.charAt(r) == s.charAt(r - l)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
    }
}
