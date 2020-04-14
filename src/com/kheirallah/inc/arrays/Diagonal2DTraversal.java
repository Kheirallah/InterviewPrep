package com.kheirallah.inc.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]
 */
public class Diagonal2DTraversal {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = findDiagonalOrder(matrix);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    /*
    Time O(rowlength * columnLength)
    Space O(rowLength, columnLength) intermediate can be as long as the length of one diagonal and result is the size of rLength*cLength
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int rowLength = matrix.length, columnLength = matrix[0].length;
        int[] result = new int[rowLength * columnLength];
        int k = 0;

        List<Integer> intermediate = new ArrayList<>();

        for (int d = 0; d < rowLength + columnLength - 1; d++) {
            intermediate.clear();

            int r = d < columnLength ? 0 : d - columnLength + 1;
            int c = d < columnLength ? d : columnLength - 1;

            while (r < rowLength && c > -1) {
                intermediate.add(matrix[r++][c--]);
            }

            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int value : intermediate) {
                result[k++] = value;
            }
        }

        return result;
    }
}
