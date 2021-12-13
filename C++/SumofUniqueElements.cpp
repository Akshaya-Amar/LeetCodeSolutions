/*

Source: https://leetcode.com/problems/sum-of-unique-elements/

Time: O(n), where n is the length of the given integer array(nums)
Space: O(m), where m is the max value of num

*/

class Solution {
public:
  int sumOfUnique(vector<int>& nums) {

    int freq[101] = {0};
    int sum = 0;

    for(int num : nums) {

      int freqOfNum = ++freq[num];

      if(freqOfNum == 1) {
        sum += num;
      } else if(freqOfNum == 2) {
        sum -= num;
      }
    }

    return sum;
  }
};
