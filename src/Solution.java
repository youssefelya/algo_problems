


import data_struct.TreeNode;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        String s = "j?qg??b";
        System.out.println(modifyString(s));

    }


    public static String modifyString(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        char prevChar = '#';
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                char c = 'a';
                while (c == prevChar || (i + 1 < n && c == s.charAt(i + 1))) c++;
                str.append(c);
                prevChar = c;
            } else {
                str.append(s.charAt(i));
                prevChar = s.charAt(i);
            }
        }
        return str.toString();
    }


}






