package com.kheirallah.inc.arrays;

//Easy
//Crack the coding interview 1.8

/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
 */

//Time complexity O(n^2) since we must iterate through the same 2D array regardless
//Space Complexity O(N), for boolean arrays
public class ZeroMatrix {

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 0, 8},
                        {9, 10, 11, 12},
                        {0, 14, 15, 16}
                };
        printMatrix(mat, mat[0].length);
        zeroMatrix(mat);
        printMatrix(mat, mat[0].length);
    }

    private static void printMatrix(int[][] mat, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private static void zeroMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}