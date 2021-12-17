/*

Source: https://leetcode.com/problems/concatenation-of-array/

Time: O(n), where n is the size of nums
Space: O(1), in-place

*/

class Solution {
public:
  vector<int> getConcatenation(vector<int>& nums) {

    int size = nums.size();
    nums.resize(size << 1);

    for(int i = 0; i < size; ++i) {
      nums[i + size] = nums[i];
    }

    return nums;
  }
};
