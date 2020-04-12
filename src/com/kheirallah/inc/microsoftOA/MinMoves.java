package com.kheirallah.inc.microsoftOA;

/*
given a string of 'a's and 'b's, write a function that returns the minimum number of required moves to obtain a string
without 3 identical consecutive letters
 */
public class MinMoves {

    public static void main(String[] args) {
        String value = "baaaaa";
        String value2 = "baaabbaabbba";
        System.out.println("Minimum moves for first example: " + minMoves(value));
        System.out.println("Minimum moves for second example: " + minMoves(value2));
    }

    //Time O(N)
    //Space O(1)
    private static int minMoves(String input) {
        int moves = 0;
        for (int i = 0; i < input.length(); ) {
            int next = i + 1;
            while (next < input.length() && input.charAt(i) == input.charAt(next)) {
                next++;
            }
            moves += (next - i) / 3;
            i = next;
        }
        return moves;
    }

}

//Debug example
//    public static String[] solution(int N, int K) {
//        if (N == 0) {
//            return new String[]{""};
//        }
//        ArrayList<String> result = new ArrayList<String>();
//        for (String p : solution(N - 1, K - 1)) {
//            for (char l : new char[]{'a', 'b', 'c'}) {
//                int pLen = p.length();
//                if (pLen == 0 || p.charAt(pLen - 1) != l) {
//                    result.add(p + l);
//                }
//            }
//        }
//        int prefSize = Math.min(result.size(), K);
//        return result.subList(0, prefSize).toArray(new String[prefSize]);
//    }
//
//    public static void main(String[] args) {
//        String[] values = solution(9, 1);
//        for (String val : values) {
//            System.out.println(val);
//        }
//    }