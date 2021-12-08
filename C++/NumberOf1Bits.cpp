/*

Source: https://leetcode.com/problems/number-of-1-bits

COMPLEXITY:
Time: O(1), maximum number of possible signed bits in int type are 32, so O(32) ~ O(1)
Space: O(1), in-place

*/

class Solution {
public:
  int hammingWeight(uint32_t n) {

    int setBitCount = 0;

    while(n != 0) {
      n &= n - 1;
      ++setBitCount; // to clear the rightmost set bit
    }

    return setBitCount;
  }
};
