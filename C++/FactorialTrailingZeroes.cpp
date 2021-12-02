/*

Source: https://leetcode.com/problems/factorial-trailing-zeroes/

Time: O(log base5 n), here, the loop will iterate for maximum log base5 n times for a given integer n
Space: O(1), in-place

*/

class Solution {
public:
    int trailingZeroes(int n) {

        int trailingZeroesCount = 0;

        while(n >= 5) {
            trailingZeroesCount += n / 5;
            n /= 5;
        }

        return trailingZeroesCount;
    }
};
