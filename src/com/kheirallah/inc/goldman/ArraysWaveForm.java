package com.kheirallah.inc.goldman;

import java.util.Arrays;

public class ArraysWaveForm {

    public static void main(String[] args) {
        int[] arr = {10, 90, 49, 2, 1, 5, 23};
        makeEfficientWave(arr);
        for (int value : arr) {
            System.out.println(value);
        }
    }

    //Time complexity O(NLOGN) if a sort like merge or heap is used
    //Space Complexity O(1)
    private static void makeWave(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i += 2) {
            swapHelper(arr, i, i + 1);
        }
    }

    //Time complexity O(N)
    //Space Complexity O(1)
    private static void makeEfficientWave(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            if (i > 0 && arr[i - 1] > arr[i]) {
                swapHelper(arr, i - 1, i);
            }

            if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                swapHelper(arr, i, i + 1);
            }
        }
    }

    private static void swapHelper(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
