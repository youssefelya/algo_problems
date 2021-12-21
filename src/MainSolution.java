import data_struct.ListNode;

import java.util.*;

public class MainSolution {


    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int left =0;
        int right = n;
        //int mid = left + (right-left)/2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int low = 0;
        int high = n - 1;
        int mid = (low + high) >>> 1;
        while (low <= high) {
            mid = (low + high) >>> 1;
            boolean version = isBadVersion(mid);
            if (version) {
                if (mid > 0 && !isBadVersion(mid - 1))
                    return mid;
                else if (mid == 0) return mid;
                low = mid + 1;
            } else {
                if (mid + 1 < n && isBadVersion(mid + 1))
                    return mid;
                else if (mid == n - 1) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }


    static boolean isBadVersion(int b) {
        return false;
    }


}
