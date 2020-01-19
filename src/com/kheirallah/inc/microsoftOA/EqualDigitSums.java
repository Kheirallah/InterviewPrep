package com.kheirallah.inc.microsoftOA;

import java.util.HashMap;
import java.util.Map;

public class EqualDigitSums {

    private static int solution(int[] arr) {
        Map<Integer, Integer> sums = new HashMap<>();
        int maxSum = -1;
        for (int val : arr) {
            int sum = getSum(val);
            if (sums.get(sum) == null) {
                sums.put(sum, val);
                continue;
            }
            maxSum = Math.max(maxSum, sums.get(sum) + val);
            if (val > sums.get(sum)) {
                sums.put(sum, val);
            }
        }
        return maxSum;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{51, 71, 17, 42}));
        System.out.println(solution(new int[]{42, 33, 60}));
        System.out.println(solution(new int[]{51, 32, 43}));
    }
}
