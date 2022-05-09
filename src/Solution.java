
import data_struct.ListNode;

import java.io.IOException;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(12, 12);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        String[] strs = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsHelper(digits, 0, strs, new StringBuilder(), list);
        return list;
    }

    private void letterCombinationsHelper(String digits, int i, String[] array, StringBuilder str, List<String> list) {
        if (i > digits.length()) return;
        if (str.length() == digits.length()) {
            list.add(str.toString());
            return;
        }
        int val = Character.getNumericValue(digits.charAt(i));
        for (char c : array[val - 1].toCharArray()) {
            str.append(c);
            letterCombinationsHelper(digits, i + 1, array, str, list);
            str.deleteCharAt(str.length() - 1);
        }
    }


}






