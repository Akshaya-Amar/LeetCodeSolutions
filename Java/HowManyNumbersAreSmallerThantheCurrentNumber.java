/*

Source: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

Time: O(n + m), where n is the length of array and m is the maximum value of num
Space: O(m), where m is the maximum value of num

*/

class Solution {
  public int[] smallerNumbersThanCurrent(int[] nums) {

    int[] freq = new int[102];

    for(int num : nums) {
      ++freq[num + 1];
    }

    for(int i = 1; i < 102; ++i) {
      freq[i] += freq[i - 1];
    }

    int len = nums.length;
    for(int i = 0; i < len; ++i) {
      nums[i] = freq[nums[i]];
    }

    return nums;
  }
}
