package com.kheirallah.inc.goldman;

import java.util.HashMap;
import java.util.Map;

public class ArraysEqual {

    public static void main(String[] args) {
        int arr1[] = {3, 5, 2, 5, 2};
        int arr2[] = {2, 3, 5, 5, 2};

        System.out.println(isEqual(arr1, arr2));
    }

    /*
    Time complexity: O(N), iterate through two arrays which should be of same size
    Space Complexity: O(N), utilizing a new hashmap to store counts
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        //have to be the same size to be equal
        if (arr1.length != arr2.length) {
            return false;
        }

        Map<Integer, Integer> counts = new HashMap<>();

        for (int value : arr1) {
            if (!counts.containsKey(value)) {
                //puts the value and a single occurrence if the value isn't already in the map
                counts.put(value, 1);
            } else {
                int count = counts.get(value);
                count++;
                counts.put(value, count);
            }
        }

        for (int value : arr2) {
            //either the value is not in the map or this array has too many occurrences of it so they are not equal
            if (!counts.containsKey(value) || counts.get(value) == 0) {
                return false;
            } else {
                int count = counts.get(value);
                count--;
                counts.put(value, count);
            }
        }

        //comparisons have passed, arrays are equal
        return true;
    }
}
