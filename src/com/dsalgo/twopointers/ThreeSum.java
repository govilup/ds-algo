package com.dsalgo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8 )), -1));
    }

    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        int result = Integer.MAX_VALUE - 1;
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) {
            int a = i;
            int b = i + 1;
            int c = A.size() - 1;
            while(b < c) {
                int sum = A.get(a) + A.get(b) + A.get(c);

                if(Math.abs(sum - B) < Math.abs(result - B)) {
                    result = sum;
                }

                if(sum > B) {
                    c--;
                } else {
                    b++;
                }

                if(sum == B) {
                    return B;
                }
            }
        }

        return result;
    }
}
