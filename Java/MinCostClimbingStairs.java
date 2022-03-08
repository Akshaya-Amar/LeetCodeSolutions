/*

Source: https://leetcode.com/problems/min-cost-climbing-stairs/

Time: O(n), where n is the length of the given array(cost)
Space: O(1), in-place

*/

class Solution {
  public int minCostClimbingStairs(int[] cost) {

    int len = cost.length;
    int first = cost[0];
    int second = cost[1];

    for (int i = 2; i < len; ++i) {
      int curr = cost[i] + Math.min(first, second);
      first = second;
      second = curr;
    }

    return Math.min(first, second);
  }
}
