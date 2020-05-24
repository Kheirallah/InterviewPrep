package com.kheirallah.inc.facebook;

public class StringDecoding {
    public static void main(String[] args) {
        System.out.print(isValid("Facebook", "F6k"));
    }

    //"Facebook", "F6k"
    public static boolean isValid(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (Character.isLetter(b.charAt(i))) {
                if (a.charAt(i) != b.charAt(i)) return false;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(b.charAt(i));
                int j = i + 1;
                while (j < b.length() && !Character.isLetter(b.charAt(j))) {
                    sb.append(b.charAt(j));
                    j++;
                }
                int value = Integer.parseInt(sb.toString());
                if (a.length() - value < i) {
                    return false;
                }
                i += value;
                sb = new StringBuilder();
            }
        }
        return true;
    }
}
