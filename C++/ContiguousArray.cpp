/*

Source: https://leetcode.com/problems/contiguous-array/

Time: O(n), where n is the size of the given array(nums)
Space: O(n), map is required to store the indexes for each unique sum

*/

class Solution {
public:
  int findMaxLength(vector<int>& nums) {

    unordered_map<int, int> map{{0, -1}};

    int sum = 0;
    int maxLen = 0;
    int size = nums.size();

    for(int i = 0; i < size; ++i) {

      sum += (nums[i] == 1) ? 1 : -1;

      if(map.count(sum)) {

        int subArrayLen = i - map[sum];

        if(subArrayLen > maxLen) {
          maxLen = subArrayLen;
        }

      } else {
        map[sum] = i;
      }
    }

    return maxLen;
  }
};
