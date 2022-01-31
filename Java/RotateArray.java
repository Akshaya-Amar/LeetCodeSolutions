/*

Source: https://leetcode.com/problems/rotate-array/

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public void rotate(int[] nums, int k) {

    int len = nums.length;
    k %= len;

    rotate(nums, 0, len - 1);
    rotate(nums, 0, k - 1);
    rotate(nums, k, len - 1);

  }

  private void rotate(int[] nums, int start, int end) {

    while(start < end) {

      int temp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = temp;

    }
  }
}
