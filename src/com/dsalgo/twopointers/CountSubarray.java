package com.dsalgo.twopointers;

import java.util.HashMap;
import java.util.Map;

public class CountSubarray {

    public static void main(String[] args) {
        int[] A = new int[]{80, 4, 83, 93, 88, 30, 31, 6, 97, 15, 5, 25, 27, 80, 12, 55, 18, 52, 95, 54, 14, 96, 86, 5, 61, 79, 60, 66, 48, 48, 14, 52, 81, 63, 84, 69, 46, 61, 43, 2, 16, 72, 64, 59, 56, 23, 67, 97, 5, 39, 37, 32, 19, 50, 48, 64, 10, 83, 29, 100};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int len = A.length;
        if(len == 1) {
            return 1;
        }

        int i = 0, j = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(j < len) {
            if(map.containsKey(A[j])) {
                map.put(A[j], map.get(A[j]) + 1);
            } else {
                map.put(A[j], 1);
            }

            if(map.get(A[j]) == 1) {
                ans += map.size();
            }

            if(map.get(A[j]) > 1) {
                while(A[i] != A[j]) {
                    map.remove(A[i]);
                    i++;
                }
                if(A[i] == A[j]) {
                    map.put(A[j], map.get(A[j]) - 1);
                    i++;
                    ans += map.size();
                }
            }
            j++;
        }
        return ans;
    }
}
