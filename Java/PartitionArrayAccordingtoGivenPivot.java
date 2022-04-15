/*

Source: https://leetcode.com/problems/partition-array-according-to-given-pivot/

4 Approaches

Approach 1 (Brute force, iterating the whole array 3 times)

Basic Idea:
Iterate through the array and add all the elements, which are less than the given pivot, in the resultant array
Again iterate through the array and add all the elements, which are equal to the given pivot, in the resultant array
Now, iterate through the array once again and add all the elements, which are greater than the given pivot, in the resultant array

Time: O(n), where n is the number of the given array(nums)
Space: O(n), we need an extra array(res) to rearrange elements

*/

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int[] res = new int[nums.length];
    int i = 0;

    for(int num : nums) {
      if(num < pivot) {
        res[i++] = num;
      }
    }

    for(int num : nums) {
      if(num == pivot) {
        res[i++] = num;
      }
    }

    for(int num : nums) {
      if(num > pivot) {
        res[i++] = num;
      }
    }

    return res;
  }
}

/*

Approach 2 (Better than approach 1 as we are not doing whole iteration for 3 times)

Basic Idea:
Iterate through the array, add the elements, which are less than the given pivot, in the resultant array and track count of elements equal to the pivot simultaneously
Add all the elements equal to the pivot in the resultant array
Iterate through the array once again to add all the elements, which are greater than the given pivot, in the resultant array

Time: O(n), where n is the number of the given array(nums)
Space: O(n), we need an extra array(res) to rearrange elements

*/

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int elementsEqualToPivot = 0;
    int j = 0;

    for(int i = 0; i < len; ++i) {
      if(nums[i] < pivot) {
        res[j++] = nums[i];
      } else if(nums[i] == pivot) {
        ++elementsEqualToPivot;
      }
    }

    while(--elementsEqualToPivot >= 0) {
      res[j++] = pivot;
    }

    for(int i = 0; i < len; ++i) {
      if(nums[i] > pivot) {
        res[j++] = nums[i];
      }
    }

    return res;
  }
}

/*

Approach 3 (Two pointer approach, more optimized than approach 2 as we are performing whole iteration only for 1 time)

Time: O(n), where n is the number of the given array(nums)
Space: O(n), we need an extra array(res) to rearrange elements

*/

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int left = 0;
    int right = len - 1;
    int elementsEqualToPivot = 0;

    for(int i = 0, j = len - 1; i < len; ++i, --j) {

      if(nums[i] < pivot) {
        res[left++] = nums[i];
      } else if(nums[i] == pivot) {
        ++elementsEqualToPivot;
      }

      if(nums[j] > pivot) {
        res[right--] = nums[j];
      }
    }

    while(--elementsEqualToPivot >= 0) {
      res[left++] = pivot;
    }

    return res;
  }
}

/*

Approach 4 (Two pointer approach only and same idea as approach 3, but more optimized than approach 3 by avoiding extra elementsEqualToPivot variable and avoiding else condition to track the count of elements which are equal to pivot)

Basic Idea:
Traverse from start and end of the array simultaneously
If the element at the start is less than the pivot, then add the element at the start of the resultant array
If the element at the end is more than the pivot, then add the element at the end of the resultant array
After adding elements, which are less than pivot and more than pivot, the remaining ones are elements equal to pivot only. Now, add them in the array too

Time: O(n), where n is the number of the given array(nums)
Space: O(n), we need an extra array(res) to rearrange elements

*/

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int left = 0;
    int right = len - 1;

    for(int i = 0, j = len - 1; i < len; ++i, --j) {

      if(nums[i] < pivot) {
        res[left++] = nums[i];
      }

      if(nums[j] > pivot) {
        res[right--] = nums[j];
      }
    }

    while(left <= right) {
      res[left++] = pivot;
    }

    return res;
  }
}
