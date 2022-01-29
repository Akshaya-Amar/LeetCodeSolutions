/*

Source: https://leetcode.com/problems/search-in-rotated-sorted-array/

Time: O(log base2 n), where n is the length of the given array(nums) and (log base2 n) is the maximum possible iterations
Space: O(1), in-place

*/

// commented solution
class Solution {
  public int search(int[] nums, int target) {

    int end = nums.length - 1;

    // if the array is not rotated i.e. if the array is strictly increasing[eg: {1,2,3,4}], then
    if(nums[0] < nums[end]) {
      return indexOfTarget(nums, 0, end, target); // directly return the index of target if present, else return -1
    }

    // find the index of minimum element in nums
    int start = 0;
    int firstElement = nums[0];
    while(start < end) {

      int mid = (start + end) >> 1;

      // if the current element is minimum, then store it's index and stop iteration
      if(mid > 0 && nums[mid] < nums[mid - 1]) {
        start = mid;
        break;
      }

      if(nums[mid] >= firstElement) { // to search in right sorted part
        start = mid + 1;
      } else { // to search in left sorted part
        end = mid;
      }
    }

    // store the index of min element in nums
    int indexOfMinElement = start;
    // if the minimum element is equal to the the target, then
    if(nums[indexOfMinElement] == target) {
      return indexOfMinElement; //directly return it's index
    }

    start = 0;
    end = nums.length - 1;

    // if the target element is on the right sorted part, then
    if(target < firstElement) {
      start = indexOfMinElement; // search from index of minimum element to the end of the array(nums)
    } else { // if the target element is on the left side of the sorted array
      end = indexOfMinElement - 1; // search from 0 to one previous element from index of minimum element
    }

    // now as we know which sorted part(left or right) to search, do standard binary search
    // search for the index of target if the target is present in the nums, else return -1
    return indexOfTarget(nums, start, end, target);
  }

  // standard binary search
  private int indexOfTarget(int[] nums, int start, int end, int target) {

    while(start <= end) {

      int mid = (start + end) >> 1;

      if(nums[mid] == target) {
        return mid;
      }

      if(nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return -1;
  }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------

// solution without comments
class Solution {
  public int search(int[] nums, int target) {

    int end = nums.length - 1;
    if(nums[0] < nums[end]) {
      return indexOfTarget(nums, 0, end, target);
    }

    int start = 0;
    int firstElement = nums[0];
    while(start < end) {

      int mid = (start + end) >> 1;

      if(mid > 0 && nums[mid] < nums[mid - 1]) {
        start = mid;
        break;
      }

      if(nums[mid] >= firstElement) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    int indexOfMinElement = start;
    if(nums[indexOfMinElement] == target) {
      return indexOfMinElement;
    }

    start = 0;
    end = nums.length - 1;
    if(target < firstElement) {
      start = indexOfMinElement;
    } else {
      end = indexOfMinElement - 1;
    }

    return indexOfTarget(nums, start, end, target);
  }

  private int indexOfTarget(int[] nums, int start, int end, int target) {

    while(start <= end) {

      int mid = (start + end) >> 1;

      if(nums[mid] == target) {
        return mid;
      }

      if(nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return -1;
  }
}
