/*

Source: https://leetcode.com/problems/complement-of-base-10-integer/

Time: O(log base2 n), where n is the given number(num) and (log base2 n) means that the loop will iterate for a maximum of (log base2 n) times.
i.e. if n = 10, then the loop will iterate for 4((logn + 1) ~ logn) times. 6 times in case if n = 32.
Space: O(1), in-place

*/

class Solution {
  public int bitwiseComplement(int n) {

    if (n == 0) {
      return 1;
    }

    int complement = n;
    int mask = 1;

    while(n != 0) {

      complement ^= mask;
      mask <<= 1;
      n >>= 1;
    }

    return complement;
  }
}
