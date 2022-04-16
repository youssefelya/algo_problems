
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

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) return result;
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
}






