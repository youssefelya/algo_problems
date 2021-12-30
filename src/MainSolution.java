
import data_struct.TreeNode;

import java.util.*;

public class MainSolution {
    public static void main(String[] args) throws Exception {
        String s = "4321";
        int k = 4;
        System.out.println(minInteger(s, k));
    }

    /*
    4321 -- > 3421  -> 3241 --> 3214  -->
    4321 -- > 3421  -> 3412 --> 3142  -->
     */
    public static String minInteger(String num, int k) {
        return minIntegerHelper(num, 0, k);
    }

    private static String minIntegerHelper(String num, int i, int k) {
        if (i >= num.length() - 1 || k == 0) return num;
        int v0 = i > 0 ? Character.getNumericValue(num.charAt(i - 1)) : -1;
        int v1 = Character.getNumericValue(num.charAt(i));
        int v2 = Character.getNumericValue(num.charAt(i + 1));
        if (v0 != -1 && v0 > v1)
            return minIntegerHelper(num.substring(0, i - 1) + v1 + "" + v0 + num.substring(i + 1), i + 1, k - 1);
        else if (v2 < v1)
            return minIntegerHelper(num.substring(0, i) + v2 + "" + v1 + num.substring(i + 2), i + 1, k - 1);
        else
            return minIntegerHelper(num, i + 1, k);
    }


}
