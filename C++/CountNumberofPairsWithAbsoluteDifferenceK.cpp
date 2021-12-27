/*

Source: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/submissions/

Time: O(n + m), where n is the size of the given array(nums) and m is the max value
Space: O(m), where m is the max value given

*/

class Solution {
public:
  int countKDifference(vector<int>& nums, int k) {

    int freq[101] = {};
    int res = 0;

    for(int num : nums) {
      ++freq[num];
    }

    for(int i = k + 1; i < 101; ++i) {
      res += freq[i] * freq[i - k];
    }

    return res;
  }
};
