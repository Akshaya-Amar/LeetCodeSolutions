/*

Source: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/

Time: O(n + k), where n is the length of the given string(s) and k is the given integer
Space: O(1), in-place

*/

class Solution {
public:
  int getLucky(string s, int k) {

    int res = 0;
    for(char ch : s) {

      int val = ch - 96;

      if(val > 9) {
        res += (val / 10) + (val % 10);
      } else {
        res += val;
      }
    }

    while(--k > 0 && res > 9) {

      int sumOfDigits = 0;

      while(res != 0) {
        sumOfDigits += res % 10;
        res /= 10;
      }

      res = sumOfDigits;
    }

    return res;
  }
};
