/*

Source: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/

Time: O(n + k), where n is the length of the given string(s) and k is the given integer
Space: O(1), in-place

*/

class Solution {
public:
  int getLucky(string s, int k) {

    int num = 0;
    for(char ch : s) {

      int val = ch - 96;

      if(val > 9) {
        num += (val / 10) + (val % 10);
      } else {
        num += val;
      }
    }

    while(--k > 0 && num > 9) {

      int sumOfDigits = 0;

      while(num != 0) {
        sumOfDigits += num % 10;
        num /= 10;
      }

      num = sumOfDigits;
    }

    return num;
  }
};
