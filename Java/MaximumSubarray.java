/*

Source: https://leetcode.com/problems/maximum-subarray/

2 Approaches

Approach 1 (Brute force but will give TLE)

Time: O(n ^ 2), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int maxSubArray(int[] nums) {

    int max = nums[0];
    int len = nums.length;

    for(int i = 0; i < len; ++i) {

      if(nums[i] > max) {
        max = nums[i];
      }

      int sum = nums[i];

      for(int j = i + 1; j < len; ++j) {

        sum += nums[j];

        if(sum > max) {
          max = sum;
        }
      }
    }

    return max;
  }
}

-------------------------------------------------------------------------------------------------------

/*

Approach 2 (Kadane's algorithm)

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/


class Solution {
  public int maxSubArray(int[] nums) {

    int maxSoFar = nums[0];
    int maxEnding = nums[0];
    int len = nums.length;

    for(int i = 1; i < len; ++i) {

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
}
