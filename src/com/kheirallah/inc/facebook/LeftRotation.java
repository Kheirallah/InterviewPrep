package com.kheirallah.inc.facebook;

/*
https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
public class LeftRotation {
    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        a = rotLeftQuicker(a, 4);
        for (int value : a) {
            System.out.print(value + " ");
        }
    }

    //Time O(n*d)
    //Space O(1)
    private static int[] rotLeft(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = temp;
        }
        return a;
    }

    //Time O(n)
    //Space O(n)
    private static int[] rotLeftQuicker(int[] a, int d) {
        int[] newArr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            newArr[i] = a[(i + d) % a.length];
        }
        return newArr;
    }
}
