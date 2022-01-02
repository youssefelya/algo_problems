


import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    /*
    Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
     */

    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        for (int i = 0; i < time.length; i++)
            time[i] = time[i] % 60;
        System.out.println(Arrays.toString(time));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0, cnt[] = new int[60];
        for (int i = 0; i < time.length; i++) cnt[time[i] % 60] += 1;
        for (int i = 1; i < 30; i++) ans += cnt[i] * cnt[60 - i];
        return ans + cnt[0] * (cnt[0] - 1) / 2 + cnt[30] * (cnt[30] - 1) / 2;
    }

}
