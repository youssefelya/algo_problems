import data_struct.ListNode;
import data_struct.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class MainSolution {
    void g() {
        isFifty(10);
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodStringHelper(s, 0));

    }


    //https://leetcode.com/problems/decode-string/submissions/
    public String decodeString(String s) {
        return decodStringHelper(s, 0);
    }

    private static String decodStringHelper(String s, int i) {
        if (i < s.length() && s.charAt(i) == ']') i++;
        if (i >= s.length()) return "";
        StringBuilder str = new StringBuilder();
        while (i < s.length() && (Character.isAlphabetic(s.charAt(i)) || s.charAt(i) == ']')) str.append(s.charAt(i++));
        if (i < s.length() && s.charAt(i) == '[') i++;
        if (i < s.length()) {
            StringBuilder number = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) number.append(s.charAt(i++));
            i--;
            int val = number.length() > 0 ? Integer.parseInt(number.toString()) : 1;
            String result = decodStringHelper(s, i + 2);
            String h[] = getRepeatedString(result);
            for (int v = 0; v < val - 1; v++)
                str.append(h[0]);
            str.append(h.length > 1 ? h[0] + h[1] : h[0]);
        }
        return str.toString();
    }

    private static String[] getRepeatedString(String result) {
        for (int i = 0; i < result.length(); i++)
            if (result.charAt(i) == ']')
                return new String[]{result.substring(0, i), result.substring(i)};
        return null;
    }


    int isFifty(int n) {
        // just to make sure that we have positive probebility to find our answer;
        int bound = n + 51;
        Random random = new Random();
        int answer = random.nextInt(bound);
        while (answer != 50) answer = random.nextInt(bound);
        return answer;
    }


}
