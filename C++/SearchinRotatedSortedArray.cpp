/*

Source: https://leetcode.com/problems/search-in-rotated-sorted-array/

Time: O(log base2 n), where n is the size of the given vector(nums) and (log base2 n) is the maximum possible iterations
Space: O(1), in-place

*/

class Solution {
public:
  int search(vector<int>& nums, int target) {

    int end = nums.size() - 1;

    if(nums[0] < nums[end]) {
      return indexOfTarget(nums, 0, end, target);
    }

    int start = 0;
    while(start < end) {

      int mid = (start + end) >> 1;

      if(mid > 0 && nums[mid] < nums[mid - 1]) {
        start = mid;
        break;
      }

      if(nums[mid] > nums[end]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    int indexOfMinElement = start;
    if(nums[indexOfMinElement] == target) {
      return indexOfMinElement;
    }

    start = 0;
    end = nums.size() - 1;
    if(target > nums[indexOfMinElement] && target <= nums[end]) {
      start = indexOfMinElement;
    } else {
      end = indexOfMinElement - 1;
    }

    return indexOfTarget(nums, start, end, target);
  }

private:
  int indexOfTarget(vector<int>& nums, int start, int end, int target) {

    while(start <= end) {

      int mid = (start + end) >> 1;

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
