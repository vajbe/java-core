//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
package DSA.ArrayString;

public class BuySellStock {

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }

    public static void main(String[] args) {
        BuySellStock s = new BuySellStock();
        // s.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}