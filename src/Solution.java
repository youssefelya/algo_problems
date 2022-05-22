import data_struct.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for (int test = 1; test <= testCase; test++) {
            int N = Integer.parseInt(bf.readLine());
            String oldPassword = bf.readLine();
            System.out.println("Case #" + test + ": " + getNewPassword(oldPassword));
        }
    }

    private static String getNewPassword(String oldPassword) {
        boolean hasSpecialCharacter = false;
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        StringBuffer stringBuffer = new StringBuffer(oldPassword);
        int n = oldPassword.length();
        for (int i = 0; i < n; i++) {
            char c = oldPassword.charAt(i);
            if (Character.isDigit(c)) hasDigit = true;
            else if (Character.isAlphabetic(c)) {
                char upper = Character.toUpperCase(c);
                if (c == upper) hasUpperCase = true;
                if (c != upper) hasLowerCase = true;
            } else if (c == '#' || c == '@' || c == '*' || c == '&') hasSpecialCharacter = true;
        }
        if (!hasDigit) stringBuffer.append("1");
        if (!hasLowerCase) stringBuffer.append("a");
        if (!hasUpperCase) stringBuffer.append("A");
        if (!hasSpecialCharacter) stringBuffer.append("@");
        while (stringBuffer.length() < 7) stringBuffer.append("1");
        return stringBuffer.toString();
    }


}
