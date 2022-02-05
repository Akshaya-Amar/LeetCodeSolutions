/*

Source: https://leetcode.com/problems/contiguous-array/

Time: O(n), where n is the size of the given array(nums)
Space: O(n), map is required to store the indexes for each unique sum

*/

class Solution {
  public int findMaxLength(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int sum = 0;
    int maxLen = 0;
    int len = nums.length;

    for(int i = 0; i < len; ++i) {

      sum += (nums[i] == 1) ? 1 : -1;

      Integer firstOccurredIndexWithSumVal = map.get(sum);

      if(firstOccurredIndexWithSumVal != null) {

        int subArrayLen = i - firstOccurredIndexWithSumVal;

        if(subArrayLen > maxLen) {
          maxLen = subArrayLen;
        }

      } else {
        map.put(sum, i);
      }
    }

    return maxLen;
  }
}
