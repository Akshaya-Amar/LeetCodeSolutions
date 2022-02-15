/*

Source : https://leetcode.com/problems/single-number/

Time: O(n), where n is the size of the given vector(nums)
Space: O(1), in-place

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

/*

You might be wondering why it works?
Suppose, nums[] = {5, 6, 3, 2, 6, 2, 5}
Here, only 3 is the single element
For better undestanding, group same values together and applying bitwise XOR operator(^) on them
eg: ((5 ^ 5) ^ (6 ^ 6) ^ (2 ^ 2) ^ 3)
    (0 ^ 0 ^ 0 ^ 3) --> (0 ^ 3) --> 3

What XOR property says?
1 ^ 1 = 0, so (5 ^ 5) = 0, (6 ^ 6) = 0 and (2 ^ 2) = 0
0 ^ 1 = 1, so (0 ^ 3) = 3

*/
