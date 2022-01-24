/*

Source: https://leetcode.com/problems/isomorphic-strings/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
  public boolean isIsomorphic(String s, String t) {

    char[] sCharPattern = new char[256];
    boolean[] isPatternPresent = new boolean[256];
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      char sCharMap = sCharPattern[sChar];

      if(sCharMap != 0) {
        if(sCharMap != tChar) {
          return false;
        }
      } else if(isPatternPresent[tChar]) {
        return false;
      } else {
        sCharPattern[sChar] = tChar;
        isPatternPresent[tChar] = true;
      }
    }

    return true;
  }
}
