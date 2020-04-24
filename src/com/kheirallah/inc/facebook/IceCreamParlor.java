package com.kheirallah.inc.facebook;

/*
https://www.hackerrank.com/challenges/icecream-parlor/problem
*/
public class IceCreamParlor {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 4, 5, 6};
        int[] choices = icecreamParlor(6, prices);
        for (int val : choices) System.out.print(val + " ");
    }

    //Time O(N^2)
    //Space O(1) although we use an array, it will always be of size 2
    private static int[] icecreamParlor(int m, int[] arr) {
        int[] iceCream = new int[2];
        int iceCream1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == m && i != j) {
                    if (arr[i] > arr[j]) {
                        iceCream[0] = j + 1;
                        iceCream[1] = i + 1;
                    } else {
                        iceCream[0] = i + 1;
                        iceCream[1] = j + 1;
                    }
                }
            }
        }
        return iceCream;
    }
}
