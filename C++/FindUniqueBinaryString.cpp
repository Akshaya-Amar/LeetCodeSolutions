/*

Source: https://leetcode.com/problems/find-unique-binary-string/

Time: O(n), where n is the size of given string array(nums)
Space: O(1), in-place, though we are using extra string(res) to assign desired character('0' or '1') at their appropriate place
but we will still treat space as O(1) and not O(n) because we usually don't consider the output in the space
complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
public:
  string findDifferentBinaryString(vector<string>& nums) {

    string res = nums[0];
    int size = nums.size();

    for(int i = 0; i < size; ++i) {
      res[i] = nums[i][i] ^ 1;
    }

    return res;
  }
};
