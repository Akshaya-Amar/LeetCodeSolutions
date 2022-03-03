/*

Source: https://leetcode.com/problems/is-subsequence/

Time: O(n), where n is the length of the given string(t)
Space: O(1), in-place

*/

class Solution {
public:
  bool isSubsequence(string s, string t) {

    int sLen = s.length();
    int tLen = t.length();

    if(sLen > tLen) {
      return false;
    }

    int j = 0;

    for(int i = 0; i < tLen && j < sLen; ++i) {

      char ch = s[j];

      while(i < tLen && t[i] != ch) {
        ++i;
      }

      if(i != tLen) {
        ++j;
      }
    }

    return j == sLen;
  }
};
