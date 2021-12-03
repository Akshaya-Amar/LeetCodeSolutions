/*

Source: https://leetcode.com/problems/find-peak-element

Time: O(log base2 n), where n is the length of the array and (log base2 n) is the maximum number of possible iterations
Space: O(1), in-place

*/

class Solution {
  public int findPeakElement(int[] nums) {

    int start = 0;
    int end = nums.length - 1;

    while(start < end){

      int mid = start + ((end - start) >>> 1);
      int nextIndex = mid + 1;

      if(nums[mid] < nums[nextIndex]) {
        start = nextIndex;
      }else {
        end = mid;
      }
    }

    return start;
  }
}
