/*

Source: https://leetcode.com/problems/reverse-string/

Time: O(n), where n is the length of the given array
Space: O(1), in-place

*/

class Solution {
  public void reverseString(char[] s) {

    int start = 0;
    int end = s.length - 1;

    while(start < end) {
      char temp = s[start];
      s[start++] = s[end];
      s[end--] = temp;
    }
  }
}
