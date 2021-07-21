package com.dsalgo.sorting;

import java.util.Arrays;

public class MergeSortAlgo {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 10, 1, 3, 17, 9 };
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
    }

    public static int[] mergeSort(int arr[], int low, int high) {
        if(low == high) {
            int[] ba = new int[1];
            ba[0] = arr[low];
            return ba;
        }

        int mid = (low + high) / 2;
        int[] leftSortArr = mergeSort(arr, low, mid);
        int[] rightSortArr = mergeSort(arr, mid + 1, high);
        return mergeTwoSortedArray(leftSortArr, rightSortArr);
    }

    private static int[] mergeTwoSortedArray(int[] leftSortArr, int[] rightSortArr) {
        int i = 0, j = 0;
        int[] sortedArr = new int[leftSortArr.length + rightSortArr.length];

        int k = 0;
        while(i < leftSortArr.length && j < rightSortArr.length) {
            if (leftSortArr[i] <= rightSortArr[j]) {
                sortedArr[k] = leftSortArr[i];
                i++;
            } else {
                sortedArr[k] = rightSortArr[j];
                j++;
            }
            k++;
        }

            while(i < leftSortArr.length) {
                sortedArr[k] = leftSortArr[i];
                i++;
                k++;
            }

            while(j < rightSortArr.length) {
                sortedArr[k] = rightSortArr[j];
                j++;
                k++;
            }
        return sortedArr;
    }
}
