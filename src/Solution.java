import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            while (i + 1 < n && arr[i] < arr[i + 1]) i++;
            if (i == 0 || i >= n - 1) return false;
            while (i + 1 < n && arr[i] > arr[i + 1]) i++;
            if (i == n - 1) return true;
            else return false;
        }
        return false;
    }


}
