package java_tasks.twoToOne;

import java.util.Arrays;

public class TwoToOne {
    public static String longest (String s1, String s2) {
        String res = "";
        StringBuilder chars = new StringBuilder(s1.concat(s2));
        for (int i = 0; i < chars.length(); i++) {
            for (int j = i + 1; j < chars.length(); j++){
                if (chars.charAt(i) == chars.charAt(j)){
                    chars.setCharAt(j, ' ');
                }
            }
        }
        String[] arr_str = chars.toString().split(" ");
        for (String ch : arr_str) { res += ch; }
        char[] arr = res.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

