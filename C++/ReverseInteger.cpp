/*

Source: https://leetcode.com/problems/reverse-integer/

*/

class Solution {
public:
  int reverse(int x) {

    const int maxValByTen = INT_MAX / 10;
    const int minValByTen = INT_MIN / 10;
    int rev = 0;

    while(x != 0) {

      if(rev > maxValByTen || rev < minValByTen) {
        return 0;
      }

      rev = (rev * 10) + (x % 10);
      x /= 10;
    }

    return rev;

  }
};
