/*

Source: https://leetcode.com/problems/number-of-1-bits

COMPLEXITY:
Time: O(1), maximum number of possible signed bits in int type are 32, so O(32) ~ O(1)
Space: O(1), in-place

*/

public class Solution {
  public int hammingWeight(int n) {

    int setBitCount = 0;

    while(n != 0){
      n &= (n - 1); // to clear the rightmost set bit
      ++setBitCount;
    }

    return setBitCount;
  }
}
