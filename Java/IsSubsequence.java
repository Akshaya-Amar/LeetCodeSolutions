/*

Source: https://leetcode.com/problems/is-subsequence/

Time: O(n), where n is the length of the given string(t)
Space: O(1), in-place

*/

class Solution {
  public boolean isSubsequence(String s, String t) {

    int sLen = s.length();
    int tLen = t.length();

    if(sLen > tLen) {
      return false;
    }

    int j = 0;

    for(int i = 0; i < tLen && j < sLen; ++i) {

      char ch = s.charAt(j);

      while(i < tLen && t.charAt(i) != ch) {
        ++i;
      }

      if(i != tLen) {
        ++j;
      }
    }

    return j == sLen;
  }
}
