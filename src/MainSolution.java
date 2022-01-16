

import java.util.*;

public class MainSolution {
    public static void main(String[] args) {
        int[] array = {0, 0, 1};
        System.out.println(maxDistToClosest(array));
    }

    public static int maxDistToClosest(int[] seats) {
        int n = seats.length;
        if (n == 2) return 1;
        int i = 0, ans = 0;
        int start = 0;
        while (seats[i] == 0) {
            ans++;
            i++;
        }
        while (i < n) {
            if (seats[i] == 1) {
                ans = Math.max(ans, (i - start) / 2);
                start = i;
            }
            i++;
            if (i == n) {
                ans = Math.max(ans, (i - 1 - start));
            }
        }
        return ans;
    }

}
