/*

Source: https://leetcode.com/problems/maximum-subarray/

Time: O(n), where n is the size of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int maxSubArray(vector<int>& nums) {

    int max = nums[0];
    int maxEnding = nums[0];
    int size = nums.size();

    for(int i = 1; i< size; ++i) {

      maxEnding += nums[i];

      if(nums[i] > maxEnding) {
        maxEnding = nums[i];
      }

      if(maxEnding > max) {
        max = maxEnding;
      }
    }

    return max;
  }
};
