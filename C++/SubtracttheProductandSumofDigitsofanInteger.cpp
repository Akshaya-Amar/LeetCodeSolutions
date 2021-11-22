/*

Source: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

Time: O(n), where n is the given number
Space: O(1), in-place

*/

class Solution {
public:
  int subtractProductAndSum(int n) {

    int product = 1;
    int sum = 0;

    while(n != 0) {
      int digit = n % 10;
      product *= digit;
      sum += digit;
      n /= 10;
    }

    return product - sum;
  }
};
