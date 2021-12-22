import data_struct.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainSolution {


    public static void main(String[] args) {

    }


    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid] > arr[mid - 1] && mid + 1 < n && arr[mid] > arr[mid + 1]) return mid;
            if (mid > 0 && arr[mid] > arr[mid - 1]) {
                low = mid;
            } else {
                high = mid + 1;
            }
            if (mid == 0 || mid == n - 1) return mid;
        }
        return low;
    }

    interface MountainArray {
        int get(int index);

        int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mid = findMount(mountainArr);
        int sol1 = binarSearch(target, mountainArr, 0, mid);
        int sol2 = binarSearch(target, mountainArr, mid, mountainArr.length());
        if (sol1 == -1 || sol2 == -1) return Math.max(sol2, sol1);
        return Math.min(sol1, sol2);
    }

    int binarSearch(int target, MountainArray mountainArr, int from, int to) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target)
                return mid;
            else if (target > value)
                low = mid;
            else high = mid + 1;
            if (low == high)
                return mountainArr.get(low) == target ? low : -1;
        }
        return -1;
    }

    public int findMount(MountainArray mountainArr) {
        int n = mountainArr.length();
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int midVal = mountainArr.get(mid);
            if (mid > 0)
                left = mountainArr.get(mid - 1);
            if (mid + 1 < n)
                right = mountainArr.get(mid + 1);
            if (midVal > left && midVal > right) return mid;
            if (midVal > left) {
                low = mid;
            } else {
                high = mid + 1;
            }
            if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) return mid;
        }
        return low;
    }

}
