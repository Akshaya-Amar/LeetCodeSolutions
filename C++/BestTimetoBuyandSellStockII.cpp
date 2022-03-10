/*

Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Time: O(n), where n is the size of the given vector(prices)
Space: O(1), in-place

*/

class Solution {
public:
  int maxProfit(vector<int>& prices) {

    int profit = 0;
    int buy = 0;
    int sell = 0;
    int days = prices.size();

    while(buy < days && sell < days) {

      while(buy < days - 1 && prices[buy + 1] < prices[buy]) {
        buy++;
      }

      sell = buy;

      while(sell < days - 1 && prices[sell + 1] > prices[sell]) {
        sell++;
      }

      profit += prices[sell] - prices[buy];

      buy = sell + 1;
    }

    return profit;
  }
};
