/*

Source: https://leetcode.com/problems/number-complement/

Time: O(log base2 n), where n is the given number(num) and log base2 n means that the loop will iterate for maxiumum log base2 n times.
Space: O(1), in-place

*/

class Solution {
  public int findComplement(int num) {

    int mask = 1;
    int complement = num;

    while(num != 0) {

      complement ^= mask;
      mask <<= 1;
      num >>= 1;
    }

    return complement;
  }
}
