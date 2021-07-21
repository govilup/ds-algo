package com.dsalgo.bitmanipulation;

public class ReverseBits {

    public static void main(String[] args) {
        int num = 10;

        boolean flag = false;
        for(int i = 31; i >= 0; i--) {
            int mask = (1 << i);

            if(flag) {
                if((num & mask) != 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                if((num & mask) != 0) {
                    flag = true;
                    System.out.println(1);
                }
            }
        }
    }
}
