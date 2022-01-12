/*

Source: https://leetcode.com/problems/find-greatest-common-divisor-of-array/

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int findGCD(vector<int>& nums) {

    int min = nums[0];
    int max = nums[0];
    int size = nums.size();

    for(int i = 1; i < size; ++i) {

      if(nums[i] < min) {
        min = nums[i];
      } else if(nums[i] > max) {
        max = nums[i];
      }
    }

    while(min != 0) {

      int rem = max % min;
      max = min;
      min = rem;
    }

    return max;
  }
};
