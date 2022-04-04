/*

Source: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

Approach 1 (Brute force)

Time: O(n ^ 2), where n is the length of the given array(nums)
Space: O(1), constant time

*/

class Solution {
  public int maxProduct(int[] nums) {

    int maxProduct = 0;
    int len = nums.length;

    for(int i = 0; i < len; ++i) {

      int num = nums[i];

      for(int j = i + 1; j < len; ++j) {

        int product = (num - 1) * (nums[j] - 1);

        if(product > maxProduct) {
          maxProduct = product;
        }

      }
    }

    return maxProduct;
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

    int len = nums.length;

    return (nums[len - 2] - 1) * (nums[len - 1] - 1);
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

    int maxElement = nums[0];
    int secondMaxElement = 1;
    int len = nums.length;

    for(int i = 1; i < len; ++i) {

      int num = nums[i];

      if(num > maxElement) {
        secondMaxElement = maxElement;
        maxElement = num;
      } else if(num > secondMaxElement) {
        secondMaxElement = num;
      }
    }

    return (maxElement - 1) * (secondMaxElement - 1);
  }
}
