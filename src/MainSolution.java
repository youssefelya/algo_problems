
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws Exception {
        String a = "10";
        String b = "11";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        return addBinaryHelper(a, a.length() - 1, b, b.length() - 1, 0);
    }

    private static String addBinaryHelper(String a, int i, String b, int j, int res) {
        if (i < 0 && j < 0) {
            StringBuilder str = new StringBuilder();
            while (res > 0) {
                str.append(res % 2);
                res = res / 2;
            }
            return str.reverse().toString();
        } else if (i < 0) {
            int sum = Character.getNumericValue(a.charAt(j)) + res;
            return addBinaryHelper(a, i - 1, b, j - 1, sum/2) + "" + (sum % 2);
        } else if (j < 0) {
            int sum = Character.getNumericValue(b.charAt(i)) + res;
            return addBinaryHelper(a, i - 1, b, j - 1, sum/2) + "" + (sum % 2);
        } else {
            int sum = Character.getNumericValue(a.charAt(i)) + res + Character.getNumericValue(b.charAt(j));
            return addBinaryHelper(a, i - 1, b, j - 1, sum/2) + (sum % 2);
        }
    }


}
