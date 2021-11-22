/*

Source: https://leetcode.com/problems/ugly-number/

Time: O(log(base2)n), where log(base2)n is the max number of iteration done for a given integer n
Space: O(1), in-place

*/

class Solution {
  public boolean isUgly(int n) {

    if(n <= 0) {
      return false;
    }

    while((n & 1) == 0) {
      n >>= 1;
    }

    while(n % 3 == 0) {
      n /= 3;
    }

    while(n % 5 == 0) {
      n /= 5;
    }

    return n == 1;
  }
}
