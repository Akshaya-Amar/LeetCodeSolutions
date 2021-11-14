class Solution {
  public int repeatedNTimes(int[] nums) {

    final int len = nums.length;

    for(int i = 2; i < len; ++i) {

      final int num = nums[i];

      if(num == nums[i - 1] || num == nums[i - 2]) {
        return num;
      }
    }

    return nums[0];
  }
}
