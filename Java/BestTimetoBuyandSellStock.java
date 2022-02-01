/*

Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Time: O(n), where n is the length of the given array(prices)
Space: O(1), in-place

*/

class Solution {
  public int maxProfit(int[] prices) {

    int minStockPrice = prices[0];
    int maxProfit = 0;
    int profit = 0;
    int len = prices.length;

    for(int i = 1; i < len; ++i) {

      int stockPrice = prices[i];

      if(stockPrice < minStockPrice) {
        minStockPrice = stockPrice;
      } else if((profit = stockPrice - minStockPrice) > maxProfit) {
        maxProfit = profit;
      }
    }

    return maxProfit;
  }
}
