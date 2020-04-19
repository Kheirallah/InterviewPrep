package com.kheirallah.inc.facebook;

/*
https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
public class DesignerPDFViewer {
    public static void main(String[] args) {
        int[] heights = new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        String value = "abc";
        System.out.println(designerPDFViewerArea(heights, value));
    }

    private static int designerPDFViewerArea(int[] heights, String word) {
        int max = -1;
        for (char c : word.toCharArray()) {
            max = Math.max(max, heights[c - 'a']);
        }
        return max * word.length();
    }
}
