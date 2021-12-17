/*

Source: https://leetcode.com/problems/concatenation-of-array/

Time: O(n), where n is the length of nums
Space: O(1), in-place, though we are using extra char array to assign desired character but,
we will still treat space as O(1) and not O(n) because we usually don't consider the output in the
space complexity i.e. only temporary spaces which are used to get the desired output are considered

*/

class Solution {
  public int[] getConcatenation(int[] nums) {

    int len = nums.length;
    int[] res = new int[len << 1];

    for(int i = 0; i < len; ++i)
    res[i + len] = res[i] = nums[i];

    return res;
  }
}
