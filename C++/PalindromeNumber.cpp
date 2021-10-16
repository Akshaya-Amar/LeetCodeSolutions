/*

Source: https://leetcode.com/problems/palindrome-number/

COMPLEXITY:
Time: O(1), maximum number of possible signed bits in int type are 32, so O(32) ~ O(1)
Space: O(1), in-place

*/

class Solution {
public:
  bool isPalindrome(int x) {

    if (x < 0 || (x != 0 && (x % 10) == 0)) {
      return false;
    }

    if(x < 10) {
      return true;
    }

    int rev = 0;
    while(x > rev) {
      rev = (rev * 10) + (x % 10);
      x /= 10;
    }

    return (x == rev) || (x == rev / 10);
  }
};
