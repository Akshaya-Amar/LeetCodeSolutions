/*

Source: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

Time: O(n), where n is the length of given array
Space: O(1), in-place

*/

class Solution {
  public int findNumbers(int[] nums) {

    int count = 0;
    for(int num : nums) {
      if((num >= 10 && num < 100) || (num >= 1000 && num < 10000) || (num == 100000)) {
        ++count;
      }
    }

    return count;
  }
}
