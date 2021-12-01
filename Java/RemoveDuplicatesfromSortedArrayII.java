/*

Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

Time: O(n), where n is the length of the given array
Space: O(1), in-place

*/

class Solution {
  public int removeDuplicates(int[] nums) {

    int len = nums.length;

    if(len <= 2) {
      return len;
    }

    int j = 2;

    for(int i = 2; i < len; ++i) {
      if(nums[i] > nums[j - 2]) {
        nums[j++] = nums[i];
      }
    }

    return j;
  }
}
