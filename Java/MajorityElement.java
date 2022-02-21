/*

Source: https://leetcode.com/problems/majority-element/

Time: O(n), where n is the length of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
  public int majorityElement(int[] nums) {

    int majorityElement = nums[0];
    int count = 1;
    int len = nums.length;

    for(int i = 1; i < len; ++i) {

      if(count == 0) {
        majorityElement = nums[i];
      }

      count += (nums[i] == majorityElement) ? 1 : -1;
    }

    return majorityElement;
  }
}
