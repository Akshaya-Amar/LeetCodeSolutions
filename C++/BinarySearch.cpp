/*

Source: https://leetcode.com/problems/binary-search/

Time: O(log base2 n), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int search(vector<int>& nums, int target) {

    int start = 0;
    int end = nums.size() - 1;

    while(start <= end) {

      int mid = start + ((end - start) >> 1);

      if(nums[mid] == target) {
        return mid;
      }

      if(nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return -1;
  }
};
