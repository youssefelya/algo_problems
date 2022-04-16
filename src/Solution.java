
import data_struct.ListNode;
import data_struct.TreeNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {

    }
    /*
    1,     2, 3, 5
       2
    2 ,    3, 4,5
       3
    3

     [   ]
     */

    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        list.add(1);
        n--;
        while (n > 0) {
            int v1 = list.get(i) * 2;
            int v2 = list.get(j) * 3;
            int v3 = list.get(k) * 5;
            int min = Math.min(v1, Math.min(v2, v3));
            list.add(min);
            if (min == v1) i++;
            if (min == v2) j++;
            if (min == v3) k++;
            n--;
        }
        return list.get(list.size() - 1);
    }
}






