/*

Source: https://leetcode.com/problems/maximum-subarray/

2 Approaches

Approach 1 (Brute force, but will give TLE)

Time: O(n ^ 2), where n is the size of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int maxSubArray(vector<int>& nums) {

    int max = INT_MIN;
    int size = nums.size();

    for(int i = 0; i < size; ++i) {

      int sum = 0;

      for(int j = i; j < size; ++j) {

        sum += nums[j];

        if(sum > max) {
          max = sum;
        }
      }
    }

    return max;
  }
};

--------------------------------------------------------------------------------------------------

/*

Approach 2 (Kadane's algorithm)

Time: O(n), where n is the size of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int maxSubArray(vector<int>& nums) {

    int maxSoFar = nums[0];
    int maxEnding = nums[0];
    int size = nums.size();

    for(int i = 1; i < size; ++i) {

      int num = nums[i];

      maxEnding += num;

      if(num > maxEnding) {
        maxEnding = num;
      }

      if(maxEnding > maxSoFar) {
        maxSoFar = maxEnding;
      }
    }

    return maxSoFar;
  }
};

--------------------------------------------------------------------------------------------------

/*

Approach 3 (Slightly more optimzed than approach 2)

Time: O(n), where n is the size of the given vector(nums)
Space: O(1), in-place

*/
class Solution {
public:
  int maxSubArray(vector<int>& nums) {

    int maxSoFar = nums[0];
    int maxEnd = nums[0];
    int size = nums.size();

    for(int i = 1; i < size; ++i) {

      if(maxEnd < 0) {
        maxEnd = nums[i];
      } else {
        maxEnd += nums[i];
      }

      if(maxEnd > maxSoFar) {
        maxSoFar = maxEnd;
      }
    }

    return maxSoFar;
  }
};
