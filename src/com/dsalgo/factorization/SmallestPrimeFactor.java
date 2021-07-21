package com.dsalgo.factorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SmallestPrimeFactor {

    public static void main(String[] args) {
//        List<Integer> A = new ArrayList<>(Arrays.asList(93, 51, 84, 81, 89, 82, 28, 78, 86, 35, 64, 38, 49, 99, 83));
//        Collections.sort(A);
//        int sum = A.stream().mapToInt(Integer::intValue).sum();
//
//        int s1Rev = 0;
//        for(int i = A.size() - 1; i >= A.size() - 4; i--) {
//            s1Rev += A.get(i);
//        }
//
//        int s2Rev = sum - s1Rev;
//
//        int s1 = 0;
//        for(int i = 0; i < 4; i++) {
//            s1 += A.get(i);
//        }
//
//        int s2 = sum - s1;
//        System.out.println(Math.max(Math.abs(s1Rev - s2Rev), Math.abs(s1 - s2)));
        //smallestPrimeFactor(404);

        int A = 6, B = 6, C = 4;
        int a_c = (int) Math.ceil((double) A/C );
        int b_c = (int) Math.ceil((double) B/C );
        System.out.println(a_c * b_c);
    }

    public static void smallestPrimeFactor(int n) {
        for(int f = 2; f*f <= n; f++) {
            int p = 0;
            while(n%f == 0) {
                p++;
                n /= f;
            }
            if(p > 0) {
                System.out.println(f + " - " + p);
            }
//            if(n > 1) {
//                System.out.println(n);
//            }
        }
       // return null;
    }
}
