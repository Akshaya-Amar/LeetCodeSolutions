/*

Source: https://leetcode.com/problems/valid-palindrome-ii/

Time: O(n), where n is the length of the given string(s)
Space: O(1), constant space

*/

class Solution {
public:
  bool validPalindrome(string s) {
    return isValid(s, 0, s.length() - 1, false);
  }

private:
  bool isValid(string s, int start, int end, bool isCharDeleted) {

    while(start < end) {

      if(s[start] != s[end]) {

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
};
