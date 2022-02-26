/*

Source: https://leetcode.com/problems/largest-odd-number-in-string/

Time: O(n), where n is the length of the given string(num)
Space: O(1), in-place

*/

class Solution {
  public String largestOddNumber(String num) {

    int index = num.length();

    while(--index >= 0 && ((num.charAt(index) - '0') & 1) == 0);

    return num.substring(0, index + 1);
  }
}
