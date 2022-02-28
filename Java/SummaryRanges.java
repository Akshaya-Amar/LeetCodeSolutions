/*

Source: https://leetcode.com/problems/summary-ranges/

Basic Idea:
Get the first and last index of range
eg:
nums[] = {1,2,3,5,7,8}
Here, first index of range is 0(for element 1) and
the last index of range is 2(for element 3)
Now, since first and last index here are not equal(i.e. firstIndexOfRange != lastIndexOfRange),
append the element at start index of range with the element at last index of range
i.e. "1->3"

But what if there is only single element in the range
eg:
nums[] = {1,2,3,5,7,8}
Here, element 5 at 3rd index is the only single element in it's range
In this case, the first and last index of the range will be same. So,
append only that element i.e. "5"

*/

/*

1st approach (Two pointer)

Time: O(n), where n is the size of the given array (nums)
Space: O(1), in-place, though we are using extra List(rangeList), but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public List<String> summaryRanges(int[] nums) {

    int len = nums.length;
    if(len == 0) {
      return new ArrayList<>();
    }

    StringBuilder range = new StringBuilder();
    List rangesList = new ArrayList<>();

    for(int i = 0; i < len; ++i) {

      int rangeStartIndex  = i;

      // to get the last index of range
      while((i + 1) < len && nums[i] == nums[i + 1] - 1) {
        ++i;
      }

      range.append(nums[rangeStartIndex]);

      // to check if there is not only a single sorted element
      if(i != rangeStartIndex) {
        range.append("->").append(nums[i]);
      }

      rangesList.add(range.toString());
      range.setLength(0);
    }

    return rangesList;
  }
}

/*

2nd approach (Two pointer, but more Optimized)

Time: O(n), where n is the size of the given array (nums)
Space: O(1), in-place, though we are using extra List(rangeList), but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public List<String> summaryRanges(int[] nums) {

    int len = nums.length;
    if(len == 0) {
      return new ArrayList<>();
    }

    StringBuilder range = new StringBuilder();
    List rangesList = new ArrayList<>();

    for(int i = 0; i < len;) {

      range.append(nums[i]);
      int rangeStartIndex = ++i;

      // to get the last index of range
      while(i < len && nums[i] == nums[i - 1] + 1) {
        ++i;
      }

      // to check if there is not only a single sorted element
      if(i != rangeStartIndex) {
        range.append("->").append(nums[i - 1]);
      }

      rangesList.add(range.toString());
      range.setLength(0);
    }

    return rangesList;
  }
}
