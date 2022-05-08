package jnjdPrep;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GamesOnArrays {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] strs = bf.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(strs[i]);
        boolean canBeSplit = splitArraySameAverage(array);
        System.out.println(canBeSplit ? "YES" : "NO");
    }

    public static boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) return false;
        if (nums.length == 2) return nums[0] == nums[1];
        int lenBy2 = nums.length / 2;
        List<Integer>[] left = new List[lenBy2 + 1];
        List<Integer>[] right = new List[lenBy2 + 1];
        for (int i = 0; i <= lenBy2; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }
        for (int j = 0; j < (1 << lenBy2); j++) {
            int size = 0;
            //thios i
            int leftSum = 0;
            int rightSum = 0;
            for (int i = lenBy2 - 1, mask = j; mask > 0; i--, mask >>= 1) {
                if ((mask & 1) == 1) {
                    size++;
                    leftSum += nums[i];
                    rightSum += nums[lenBy2 + i];
                }
            }
            left[size].add(leftSum);
            right[size].add(rightSum);
        }
        for (int i = 0; i <= lenBy2; i++) {
            Collections.sort(right[i]);
        }
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < left.length; i++) {
            for (int x : left[i]) {
                for (int j = 0; j < right.length; j++) {
                    if (i + j == 0 || i + j == nums.length) continue;
                    //Average has to be same
                    //(x + y) / (i + j) == (total - (x + y)) / (nums.length - (i + j))
                    double y = ((1d * total * (i + j)) / nums.length) - x;
                    if (Math.ceil(y) != y) continue;
                    if (Collections.binarySearch(right[j], (int) y) >= 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
