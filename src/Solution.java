
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int val1 = 5;
        int val2 = 2;
        double division = (double) val1 / val2;
        System.out.println(division);
    }

    static boolean isInteger(double value) {
        return value - (int) value == 0;
    }

    public static int consecutiveNumbersSum(int n) {
        int answer = 0;
        for (int k = 1; k < n; k++) {
            double division = (double) (n - k * (k - 1) / 2) / k;
            if (isValidNumber(division)) answer++;
        }
        return answer;
    }

    private static boolean isValidNumber(double division) {
        return division > 0 && division - (int) division == 0;
    }

}






