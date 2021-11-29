/*

Source: https://leetcode.com/problems/shuffle-the-array/

Time: O(n), where n is the size of the array
Space: O(1), in-place

*/

class Solution {
public:
  vector<int> shuffle(vector<int>& nums, int n) {

    int size = nums.size();
    for(int i = n; i < size; ++i) {
      nums[i] = nums[i] | nums[i - n] << 10;
    }

    int index = 0;
    for(; n < size; ++n) {
      nums[index] = nums[n] >> 10;
      nums[index + 1] = nums[n] & 1023;
      index += 2;
    }
    return nums;
  }
};
