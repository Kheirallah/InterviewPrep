package com.kheirallah.inc.arrays;

//Easy
//Crack the coding interview 1.7

/*
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
Can you do this in place?
 */

//Time complexity O(n^2) since we must iterate through a 2D array regardless
//Space Complexity O(1), no new data structures needed
public class RotateMatrix {

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        printMatrix(mat, mat[0].length);
        rotateMatrix(mat);
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

    private static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }
}