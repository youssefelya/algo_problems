
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        String strs[] = {"abc", "efg"};
        String s = "abcefg";

    }


    Map<String, Integer> visited;

    public int maxProfit(int[] prices) {
        visited = new HashMap<>();
        return maxProfitHelper(prices, 0, false, 0);
    }

  /*  public int maxProfit(int[] prices, int fee) {
        visited = new HashMap<>();
        return maxProfitHelper(prices, 0, false, fee);
    }
   */

    private int maxProfitHelper(int[] prices, int i, boolean hasStock, int fee) {
        if (i >= prices.length) return 0;
        String key = i + ":" + hasStock;
        if (visited.containsKey(key))
            return visited.get(key);
        int res = 0;
        if (hasStock) {
            int sell = maxProfitHelper(prices, i + 2, false, fee) + prices[i] - fee;
            int notSell = maxProfitHelper(prices, i + 1, true, fee);
            res = Math.max(sell, notSell);
        } else {
            int buy = maxProfitHelper(prices, i + 1, true, fee) - prices[i];
            int notBuy = maxProfitHelper(prices, i + 1, false, fee);
            res = Math.max(res, Math.max(buy, notBuy));
        }
        visited.put(key, res);
        return res;
    }

}






