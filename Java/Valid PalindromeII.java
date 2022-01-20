/*

Source: https://leetcode.com/problems/valid-palindrome-ii/

Time: O(n), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {
  public boolean validPalindrome(String s) {
    return isValid(s, 0, s.length() - 1, false);
  }

  private boolean isValid(String s, int start, int end, boolean isCharDeleted) {

    while(start < end) {

      if(s.charAt(start) != s.charAt(end)) {

        if(isCharDeleted) {
          return false;
        }

        return isValid(s, start + 1, end, true) || isValid(s, start, end - 1, true);
      }

      ++start;
      --end;
    }

    return true;
  }
}
