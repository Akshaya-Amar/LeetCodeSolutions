/*

Source: https://leetcode.com/problems/number-of-1-bits

*/
class Solution {
public:
    int hammingWeight(uint32_t n) {

        int setBitCount = 0;

        while(n != 0) {
            n &= n - 1;
            ++setBitCount; // to clear the rightmost set bit
        }

        return setBitCount;
    }
};
