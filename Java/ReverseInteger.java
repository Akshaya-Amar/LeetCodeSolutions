/*

Source: https://leetcode.com/problems/reverse-integer/

*/

class Solution {
  public int reverse(int x) {

    final int maxValByTen = Integer.MAX_VALUE / 10;
    final int minValByTen = Integer.MIN_VALUE / 10;
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
}
