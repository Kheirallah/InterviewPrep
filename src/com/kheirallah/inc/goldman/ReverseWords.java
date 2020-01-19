package com.kheirallah.inc.goldman;

public class ReverseWords {

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    public static void main(String[] args) {
        String s = "i like this program very much";
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            sb.append(splits[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
