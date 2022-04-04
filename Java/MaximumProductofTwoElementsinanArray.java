/*

Source: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

Approach 1 (Brute force)

Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), constant time

*/

class Solution {
  public int maxProduct(int[] nums) {

    int max = 0;

    for(int i = 0; i < nums.length - 1; ++i) {

      for(int j = i + 1; j < nums.length; ++j) {

        int product = (nums[i] - 1) * (nums[j] - 1);

        if(product > max) {
          max = product;
        }

      }
    }

    return max;
  }
}

-------------------------------------------------------------------------------------------------

/*

Approach 2 (Using sort, More optimized than approach 1)

Basic idea:
Sort the given array, the last two elements will given the maximum product
We can treat the last element as maximum and second last element as second maximum
Return the product of the maximum - 1 and secondmax - 1

Time: O(n log₂n), where n is the length of the given array(nums)
Space: O(1), constant time

*/

class Solution {
  public int maxProduct(int[] nums) {

    Arrays.sort(nums);

    return (nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1);
  }
}

-------------------------------------------------------------------------------------------------

/*

Approach 3 (More optimized than approach 2)

Basic idea:
From the approch 2, we can observe that we need only 2 max elements and this can be done in linear time
Return the product of the maximum - 1 and secondmax - 1

Time: O(n), where n is the length of the given array(nums)
Space: O(1), constant time

*/

class Solution {
  public int maxProduct(int[] nums) {

    int max1 = nums[0];
    int max2 = -1;
    int len = nums.length;

    for(int i = 1; i < len; ++i) {

      int num = nums[i];

      if(num > max1) {
        max2 = max1;
        max1 = num;
      } else if(num > max2) {
        max2 = num;
      }
    }

    return (max1 - 1) * (max2 - 1);
  }
}
