/*

Source: https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/

Time: O(n), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  bool canBeIncreasing(vector<int>& nums) {

    int size = nums.size();
    bool isRemoved = false;

    for(int i = 1; i < size; ++i) {

      if(nums[i] <= nums[i - 1]) {

        if(isRemoved) {
          return false;
        }

        isRemoved = true;

        if(i >= 2 && nums[i] <= nums[i - 2]) {
          nums[i] = nums[i - 1];
        }
      }
    }

    return true;
  }
};
