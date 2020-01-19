package com.kheirallah.inc.goldman;

public class UglyNumbers {

    /*
    Time complexity: O(n^2)
    Space complexity: O(1)
     */
    private static int getNthUglyNo(int n) {
        int i = 1;

        //ugly number count
        int count = 1;

        while (n > count) {
            i++;
            if (isUgly(i) == 1) {
                count++;
            }
        }
        return i;
    }

    private static int isUgly(int no) {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);

        return (no == 1) ? 1 : 0;
    }

    private static int maxDivide(int a, int b) {
        while (a % b == 0) {
            a = a / b;
        }
        return a;
    }

    /*
    Time complexity: O(n)
    Space complexity: O(n)
     */
    private static int getNthUglyNoDynamic(int n) {
        int ugly[] = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));

            ugly[i] = next_ugly_no;

            if (next_ugly_no == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = ugly[i3] * 2;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5++;
                next_multiple_of_5 = ugly[i5] * 2;
            }
        }
        return next_ugly_no;
    }

    public static void main(String args[]) {
        System.out.println(getNthUglyNo(150));
        System.out.println(getNthUglyNoDynamic(150));
    }
}
