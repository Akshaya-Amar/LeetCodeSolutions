/*

Source: https://leetcode.com/problems/number-of-1-bits

*/
public class Solution {
    public int hammingWeight(int n) {

        int setBitCount = 0;

        while(n != 0){
            n &= (n - 1); // to clear the rightmost set bit
            ++setBitCount;
        }

        return setBitCount;
    }
}
