/*

Source: https://leetcode.com/problems/n-th-tribonacci-number/

Time: O(N), where N is the given n
Space: O(1), in-place

*/ 
class Solution {
  public int tribonacci(int n) {

    final int[] sequence = {0, 1, 1};

    for(int i = 3; i <= n; ++i) {
      sequence[i % 3] = sequence[0] + sequence[1] + sequence[2];
    }

    return sequence[n % 3];
  }
}
