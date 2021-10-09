class Solution {
    public int singleNumber(int[] nums) {

        int len = nums.length;

        for(int i = 1; i < len; ++i){
            nums[0] ^= nums[i];
        }

        return nums[0];
    }
}
