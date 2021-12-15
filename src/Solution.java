

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        String abc = "abc";
        String cde = null;
        System.out.println("abc".equalsIgnoreCase(cde));

    }

    static List<int[]> list;

    public static void MyCalendarTwo() {
        list = new ArrayList<>();
    }

    public static boolean book(int start, int end) {
        int index = findRightPosition(list, start, end);
        list.add(index, new int[]{start, end});
        return tripleBooking(list, index);


    }

    private static boolean tripleBooking(List<int[]> list, int index) {
        //[10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
        if (list.size() < 3) return true;
        int prevIndex = index > 0 ? index - 1 : index + 1;
        int nextIndex = index < list.size() - 1 ? index + 1 : index - 1;
        if (nextIndex == prevIndex) return false;
        int a1 = list.get(index)[0], a2 = list.get(prevIndex)[0], a3 = list.get(nextIndex)[0];
        int b1 = list.get(index)[1], b2 = list.get(prevIndex)[1], b3 = list.get(nextIndex)[0];
        return Math.max(a1, Math.max(a2, a3)) > Math.min(b1, Math.min(b2, b3));

    }

    private static int findRightPosition(List<int[]> list, int start, int end) {
        int size = list.size();
        if (size == 0)
            return 0;
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int a = list.get(mid)[0];
            int b = list.get(mid)[1];

            if (a == start) {
                if (b < end) low = mid + 1;
                else high = mid - 1;
            } else {
                if (a < start) low = mid + 1;
                else high = mid - 1;
            }
        }
        return high + 1;
    }


}
