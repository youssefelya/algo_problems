


import java.util.*;

public class Solution {


    public static void main(String[] args) throws InterruptedException {
        String s = "bbb";
   //     System.out.println(partition(s));
    }

    public List<List<String>> partition(String s) {
        List<String> res = new ArrayList<String>();
        return dfs(s, res);
    }
    public static List<List<String>> dfs(String s, List<String> prevString) {
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                List<String> set = new ArrayList<String>(prevString);
                set.add(s.substring(0, i));
                if (i == s.length())
                    res.add(set);
                else
                    res.addAll(dfs(s.substring(i), set));
            }
        }
        return res;
    }
    public static boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(s.length() - 1 - i) != s.charAt(i))
                return false;
        }
        return true;
    }


}
