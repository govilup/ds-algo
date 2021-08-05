package com.dsalgo.recursion;

public class PrintNNumbers {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static long factorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }


    static int i = 1;

    private static void printNumber(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printNumber(n - 1);
        System.out.println(n);
    }
}
