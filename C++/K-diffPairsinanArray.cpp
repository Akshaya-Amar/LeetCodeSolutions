/*

Source: https://leetcode.com/problems/k-diff-pairs-in-an-array/

Time: O(n), where n is the length of the given vector(nums)
Space: O(n), we need a map to store the elements of vector(nums)

*/

class Solution {
public:
  int findPairs(vector<int>& nums, int k) {

    unordered_map<int,int> map;
    for(int num : nums) {
      ++map[num];
    }

    int uniquePairs = 0;
    for(auto key : map){
      if((k > 0 && map.find(key.first + k) != map.end()) || (k == 0 && key.second > 1)) {
        ++uniquePairs;
      }
    }

    return uniquePairs;
  }
};
