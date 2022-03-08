/*

Source: https://leetcode.com/problems/min-cost-climbing-stairs/

Time: O(n), where n is the length of the given array(cost)
Space: O(1), in-place

*/

class Solution {
public:
  int minCostClimbingStairs(vector<int>& cost) {

    int size = cost.size();
    int first = cost[0];
    int second = cost[1];

    for (int i = 2; i < size; ++i) {
      int curr = cost[i] + min(first, second);
      first = second;
      second = curr;
    }

    return min(first, second);
  }
};
