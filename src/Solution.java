import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 5};
        int amount = 11;
        //System.out.println(coinChange(arr, amount));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int am = 0; am <= amount; am++) {
            for (int i = 0; i < coins.length; i++) {
                if (am >= coins[i]) {
                    dp[am] = Math.min(dp[am], 1 + dp[am - coins[i]]);
                } else break;
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}






