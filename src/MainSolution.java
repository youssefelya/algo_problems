
import data_struct.ListNode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws InterruptedException {
        String str = "12*22+41/12-23+23*22";
        String[] array = str.split("\\*|\\/");
        System.out.println(Arrays.toString(array));
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        int n = s.length();
        if (n < 1) return 0;
        if (n == 1) return Character.getNumericValue(s.charAt(0));
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        while (index < n) {
            char c = s.charAt(index);
            if (c == '+') {
                stack.push(getValue(s, 1));
            } else if (c == '-') {
                stack.push(getValue(s, -1));
            } else if (c == '*') {
                int prev = stack.pop();
                stack.add(prev * getValue(s, 1));
            } else if (c == '/') {
                int prev = stack.pop();
                stack.add(prev / getValue(s, 1));
            } else {
                stack.push(getValue(s, 1));
            }
        }
        for (int val : stack)
            answer += val;
        return answer;
    }

    int index;

    private Integer getValue(String s, int sign) {
        if (!Character.isDigit(s.charAt(index))) index++;
        StringBuilder str = new StringBuilder();
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            str.append(s.charAt(index++));
        }
        return Integer.parseInt(str.toString()) * sign;
    }


}
