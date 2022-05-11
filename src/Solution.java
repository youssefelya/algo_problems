

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        System.out.println(combinationSum3(9, 50));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        ans = new ArrayList<>();
        getCombo(1, k, n, new ArrayList<Integer>());
        return ans;
    }
    private static List<List<Integer>> ans;
    private static void getCombo(int i, int k, int target, List<Integer> al) {
        if (target == 0 && al.size() == k) {
            ans.add(new ArrayList<>(al));
            return;
        }
        if (i <= 9 && target > 0) {
            getCombo(i + 1, k, target, al);
            al.add(i);
            getCombo(i + 1, k, target - i, al);
            al.remove(al.size() - 1);
        }
    }


}








