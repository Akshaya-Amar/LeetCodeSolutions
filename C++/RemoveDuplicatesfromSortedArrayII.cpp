/*

Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

Time: O(n), where n is the size of the given array
Space: O(1), in-place

*/

class Solution {
public:
  int removeDuplicates(vector<int>& nums) {

    int size = nums.size();

    if(size <= 2) {
      return size;
    }

    int j = 2;

    for(int i = 2; i < size; ++i) {
      if(nums[i] > nums[j - 2]) {
        nums[j++] = nums[i];
      }
    }

    return j;
  }
};
