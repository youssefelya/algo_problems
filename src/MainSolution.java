
import data_struct.ListNode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws InterruptedException {
        int[] arrray = {1, 5, 11, 5};
    }

    public int findComplement(int num) {
        int complement = 0;
        int length = Integer.toBinaryString(num).length();
        int n = num;
        while (n > 0) {
            complement += (Math.pow(2, length) * (1 - n % 2));
            n=n/2;length--;
        }
        return complement;
    }

}
