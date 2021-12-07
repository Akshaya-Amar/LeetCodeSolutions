/*

Source: https://leetcode.com/problems/get-maximum-in-generated-array/

Time: O(n), where n is the given integer
Space: O(n), an array of size n is needed

*/

class Solution {
  public int getMaximumGenerated(int n) {

    if(n < 2) {
      return n;
    }

    int[] res = new int[n + 1];
    res[1] = 1;
    int max = 1;

    for(int i = 2; i <= n; ++i) {

      int index = i >> 1;
      res[i] = (i & 1) == 0 ? res[index] : res[index] + res[index + 1];

      if(res[i] > max) {
        max = res[i];
      }
    }

    return max;
  }
}
