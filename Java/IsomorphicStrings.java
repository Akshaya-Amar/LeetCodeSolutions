/*

Source: https://leetcode.com/problems/isomorphic-strings/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
  public boolean isIsomorphic(String s, String t) {

    char[] sCharMaps = new char[256];
    boolean[] isMapPresent = new boolean[256];
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      char sCharMap = sCharMaps[sChar];

      if(sCharMap != 0) {
        if(sCharMap != tChar) {
          return false;
        }
      } else if(isMapPresent[tChar]) {
        return false;
      } else {
        sCharMaps[sChar] = tChar;
        isMapPresent[tChar] = true;
      }
    }

    return true;
  }
}
