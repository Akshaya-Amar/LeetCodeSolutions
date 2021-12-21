/*

Source: https://leetcode.com/problems/make-the-string-great/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  string makeGood(string s) {

    int j = 0;

    for(char ch : s) {
      if(j > 0 && (ch ^ 32) == s[j - 1]) {
        --j;
      } else {
        s[j++] = ch;
      }
    }

    return s.substr(0, j);
  }
};
