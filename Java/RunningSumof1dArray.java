/*

Source: https://leetcode.com/problems/running-sum-of-1d-array/

Time: O(n), where n is the length of the array
Space: O(1), in-place

*/

class Solution {
  public int[] runningSum(int[] nums) {

    int len = nums.length;

    for(int i = 1; i < len; ++i) {
      nums[i] += nums[i - 1];
    }

    return nums;
  }
}
