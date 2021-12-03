/*

Source: https://leetcode.com/problems/minimum-operations-to-make-array-equal/

Time: O(1)
Space: O(1), in-place

*/

class Solution {
  public int minOperations(int n) {

    return (n * n) >> 2;
  }
}
