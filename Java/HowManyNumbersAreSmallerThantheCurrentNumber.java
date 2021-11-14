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
