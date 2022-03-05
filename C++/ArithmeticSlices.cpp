/*

Source: https://leetcode.com/problems/arithmetic-slices/

Total 5 Approaches

1st approach (brute force)

Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int numberOfArithmeticSlices(vector<int>& nums) {
    int len = nums.size();
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
};

--------------------------------------------------------------------------------------------------------------------------------

/*

Approach 2 (brute force, but without using extra count variable)

Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int numberOfArithmeticSlices(vector<int>& nums) {

    int len = nums.size();
    int arithmeticSubArrays = 0;

    for(int i = 0; i < len - 2; ++i) {

      int diff = nums[i] - nums[i + 1];

      for(int j = i + 1; j < len - 1 && (nums[j] - nums[j + 1]) == diff; ++j) {
        ++arithmeticSubArrays;
      }
    }

    return arithmeticSubArrays;
  }
};

--------------------------------------------------------------------------------------------------------------------------------

/*

Approach 3 (more optimised, but uses extra space)

Time: O(n), where n is the length of the given array(nums)
Space: O(n), an array of size equal to the length of given array(nums) is required

*/

class Solution {
public:
  int numberOfArithmeticSlices(vector<int>& nums) {

    int len = nums.size();
    int arithmeticSubArrays = 0;
    int dp[len];
    memset(dp, 0, sizeof(dp));

    for(int i = 2; i < len; ++i) {

      if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        dp[i] = dp[i - 1] + 1;
        arithmeticSubArrays += dp[i];
      }
    }

    return arithmeticSubArrays;
  }
};

--------------------------------------------------------------------------------------------------------------------------------

/*

Approach 4 (space optimised Approach by eliminating extra array for space)

Basic idea
1. Minimum 3 indices are required to make arithmetic progression
2. Starting with index 2, if we found 2 same differences i.e. if the diff of 2 consecutive elements is same as diff of previous 2 consecutive elements,
it means that we have got the arithmetic sequence and the running sequence gets extended upto ith index, so increment the curr by 1 and add this curr to arithmeticSubArrays
3. If we found that ith index doesn't form arithmetic sequence, then make currently running sequence to 0(zero)

Time: O(n), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int numberOfArithmeticSlices(vector<int>& nums) {

    int len = nums.size();
    int curr = 0;
    int arithmeticSubArrays = 0;

    for(int i = 2; i < len; ++i) {

      if(nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
        arithmeticSubArrays += ++curr;
      } else {
        curr = 0;
      }
    }

    return arithmeticSubArrays;
  }
};

--------------------------------------------------------------------------------------------------------------------------------

/*

Approach 5 (eliminating if/else condition)

Time: O(n), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int numberOfArithmeticSlices(vector<int>& nums) {

    int len = nums.size();
    int arithmeticSubArrays = 0;

    for(int i = 2; i < len; ++i) {

      int diff = nums[i - 1] - nums[i - 2];
      int curr = 0;

      while(i < len && nums[i] - nums[i - 1] == diff) {
        arithmeticSubArrays += ++curr;
        ++i;
      }
    }

    return arithmeticSubArrays;

  }
};
