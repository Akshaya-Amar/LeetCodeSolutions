/*

Source: https://leetcode.com/problems/isomorphic-strings/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  bool isIsomorphic(string s, string t) {

    char sCharMaps[256] = {};
    bool isMapPresent[256] = {};
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      char sChar = s[i];
      char tChar = t[i];
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
};
