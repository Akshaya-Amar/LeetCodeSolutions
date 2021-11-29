/*

Source: https://leetcode.com/problems/shuffle-the-array/

Time: O(n), where n is the length of the array
Space: O(1), in-place

*/

class Solution {
  public int[] shuffle(int[] nums, int n) {

    int len = nums.length;
    for(int i = n; i < len; ++i) {
      nums[i] |= nums[i - n] << 10;
    }

    int index = 0;
    for(; n < len; ++n) {
      nums[index] = nums[n] >>> 10;
      nums[index + 1] = nums[n] & 1023;
      index += 2;
    }
    return nums;
  }
}
