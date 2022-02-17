/*

Source : https://leetcode.com/problems/single-number/

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int singleNumber(int[] nums) {

    int singleNumber = nums[0];
    int len = nums.length;

    for(int i = 1; i < len; ++i) {
      singleNumber ^= nums[i];
    }

    return singleNumber;
  }
}

/*

You might be wondering why it works?
Suppose, nums[] = {5, 6, 3, 2, 6, 2, 5}
Here, only 3 is the single element
For better undestanding, group same values together and applying bitwise XOR operator(^) on them
eg:
((5 ^ 5) ^ (6 ^ 6) ^ (2 ^ 2) ^ 3)
(0 ^ 0 ^ 0 ^ 3) --> (0 ^ 3) --> 3

What XOR property says?
1 ^ 1 = 0, so (5 ^ 5) = 0, (6 ^ 6) = 0 and (2 ^ 2) = 0
0 ^ 1 = 1, so (0 ^ 3) = 3

*/

---------------------------------------------------------------------------------------------------

/*

2nd approach using a single variable

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int singleNumber(int[] nums) {

    int singleNumber = nums[0];

    for(int i = nums.length - 1; i > 0; --i) {
      singleNumber ^= nums[i];
    }

    return singleNumber;
  }
}

---------------------------------------------------------------------------------------------------

/*

3rd approach without using any extra variable

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int singleNumber(int[] nums) {

    for(int i = nums.length - 1; i > 0; --i) {
      nums[0] ^= nums[i];
    }

    return nums[0];
  }
}
