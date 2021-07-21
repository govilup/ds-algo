package com.dsalgo.stringalgo;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new ArrayList<String>(Arrays.asList("abcd", "abcd", "efgh"))));
    }

    public static String longestCommonPrefix(ArrayList<String> A) {

        String smallestStr =  shortestString(A);

        String result = "";
        int len = smallestStr.length();

        for(int i = 0; i < len; i++) {
            boolean isQualified = true;
            char ch = smallestStr.charAt(i);
            for(int j = 0; j < A.size(); j++) {
                if(A.get(j).charAt(i) != ch) {
                    isQualified = false;
                    break;
                }
            }
            if(isQualified) {
                result += ch;
            } else {
                return result;
            }
        }
        return result;
    }

    public static String shortestString(ArrayList<String> A) {
        String smallest = A.get(0);
        for(String str : A) {
            if(str.length() < smallest.length()) {
                smallest = str;
            }
        }
        return smallest;
    }
}
