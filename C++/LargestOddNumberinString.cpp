/*

Source: https://leetcode.com/problems/largest-odd-number-in-string/

Time: O(n), where n is the length of the given string(num)
Space: O(1), in-place

*/

class Solution {
public:
  string largestOddNumber(string num) {

    int index = num.length();

    while(--index >= 0 && ((num[index] - '0') & 1) == 0);

    return num.substr(0, index + 1);
  }
};
