/*

Source: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Time: O(log base2 n), where n is the size of the given array(nums) and (log base2 n) is the maximum possible iterations
Space: O(1), in-place

*/

class Solution {
  public int findMin(int[] nums) {

    int start = 0;
    int end = nums.length - 1;

    if(nums[0] < nums[end]) {
      return nums[0];
    }

    while(start < end) {

      int mid = (start + end) >> 1;

      if(mid > 0 && nums[mid] < nums[mid - 1]) {
        return nums[mid];
      }

      if(nums[mid] > nums[end]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return nums[start];
  }
}
