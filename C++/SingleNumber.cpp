/*

Source : https://leetcode.com/problems/single-number/

*/

class Solution {
public:
    int singleNumber(vector<int>& nums) {

        int size = nums.size();

        for(int i = 1; i < size; ++i){
            nums[0] ^= nums[i];
        }

        return nums[0];
    }
};
