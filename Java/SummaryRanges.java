/*

Source: https://leetcode.com/problems/summary-ranges/

Time: O(n)
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
      int j = ++i;

      while(i < len && nums[i] == nums[i - 1] + 1) {
        ++i;
      }

      if(i != j) {
        range.append("->").append(nums[i - 1]);
      }

      rangesList.add(range.toString());
      range.setLength(0);
    }

    return rangesList;
  }
}
