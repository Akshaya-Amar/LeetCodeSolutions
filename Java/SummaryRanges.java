/*

Source: https://leetcode.com/problems/summary-ranges/

1st approach

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

      // to get the last index of sorted list
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

2nd approach (More Optimized)

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

      // to get the last index of sorted list
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
