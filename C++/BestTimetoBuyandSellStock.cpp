/*

Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Time: O(n), where n is the size of the given vector(prices)
Space: O(1), in-place

*/

class Solution {
public:
  int maxProfit(vector<int>& prices) {

    int minStockPrice = prices[0];
    int maxProfit = 0;
    int size = prices.size();

    for(int i = 0; i < size; ++i) {

      int stockPrice = prices[i];

      if(stockPrice < minStockPrice) {
        minStockPrice = stockPrice;
        continue;
      }

      int profit = stockPrice - minStockPrice;
      if(profit > maxProfit) {
        maxProfit = profit;
      }
    }

    return maxProfit;
  }
};
