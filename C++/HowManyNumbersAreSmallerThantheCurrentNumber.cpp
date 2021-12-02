/*

Source: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

Time: O(n + m), where n is the length of array and m is the maximum value of num
Space: O(m), where m is the maximum value of num

*/

class Solution {
public:
  vector<int> smallerNumbersThanCurrent(vector<int>& nums) {

    int freq[102] = {0};
    int size = nums.size();

    for(int i = 0; i < size; ++i) {
      ++freq[nums[i] + 1];
    }

    for(int i = 1; i < 102; ++i) {
      freq[i] += freq[i - 1];
    }

    for(int i = 0; i < size; ++i) {
      nums[i] = freq[nums[i]];
    }

    return nums;
  }
};
