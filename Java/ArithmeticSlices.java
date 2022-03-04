/*

Source: https://leetcode.com/problems/arithmetic-slices/

1st approach (brute force)
Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int numberOfArithmeticSlices(int[] nums) {

    int len = nums.length;
    int arithmeticSubArrays = 0;

    for(int i = 0; i < len - 2; ++i) {

      int diff = nums[i] - nums[i + 1];
      int count = 1;

      for(int j = i + 1; j < len - 1 && (nums[j] - nums[j + 1]) == diff; ++j) {

        if(++count >= 2) {
          ++arithmeticSubArrays;
        }
      }
    }

    return arithmeticSubArrays;
  }
}

/*

Approach 2 (brute force, but using single variable)

Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int numberOfArithmeticSlices(int[] nums) {

    int len = nums.length;
    int arithmeticSubArrays = 0;

    for(int i = 0; i < len - 2; ++i) {

      int diff = nums[i + 1] - nums[i];

      for(int j = i + 2; j < len && nums[j] - nums[j - 1] == diff; ++j) {
        ++arithmeticSubArrays;
      }
    }

    return arithmeticSubArrays;
  }
}

/*

Approach 3 (optimised)

Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int numberOfArithmeticSlices(int[] nums) {

    int prev = 0;
    int len = nums.length;
    int arithmeticSubArrays = 0;

    for(int i = 2; i < len; ++i) {

      if(nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
        arithmeticSubArrays += ++prev;
      } else {
        prev = 0;
      }
    }

    return arithmeticSubArrays;
  }
}
