import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int x = 0;
        String num1 = "12";
        String num2 = "20";
        System.out.println(multiply(num1, num2));
    }


    public static String multiply(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        String answer = "0";
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if (num1.length() < 1 || num2.length() < 1) return num1 + num2;
        if (num1.length() == 1) return multiplyHelper(Character.getNumericValue(num1.charAt(0)), num2);
        if (num2.length() == 1) return multiplyHelper(Character.getNumericValue(num2.charAt(0)), num1);
        for (int i = num1.length() - 1; i >= 0; i--) {
            String multiplyOneDigit = multiplyHelper(Character.getNumericValue(num1.charAt(i)), num2);
            answer = sum(answer, answer.length() - 1, multiplyOneDigit + str, (multiplyOneDigit + str).length() - 1, 0);
            str.append("0");
        }
        return answer;
    }

    private static String multiplyHelper(int val, String s) {
        int res = 0, n = s.length();
        StringBuilder str = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int prod = (Character.getNumericValue(s.charAt(i)) * val + res);
            res = prod / 10;
            str.append(prod % 10);
        }
        if (res > 0) str.append(res);
        return str.reverse().toString();
    }

    public static String sum(String num1, int i, String num2, int j, int res) {
        if (i < 0 && j < 0)
            return res > 0 ? String.valueOf(res) : "";
        int v1 = i < 0 ? 0 : Character.getNumericValue(num1.charAt(i));
        int v2 = j < 0 ? 0 : Character.getNumericValue(num2.charAt(j));
        int sum = v1 + v2 + res;
        return sum(num1, i - 1, num2, j - 1, sum / 10) + String.valueOf(sum % 10);
    }

}






