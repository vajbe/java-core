// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
package DSA.ArrayString;

public class BuySellStockTwo {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                profit += (prices[i] - buyPrice);
            }
            buyPrice = prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        BuySellStockTwo s = new BuySellStockTwo();
        System.out.println(s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(s.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(s.maxProfit(new int[] { 7, 6, 4, 3, 1 }));

    }
}
