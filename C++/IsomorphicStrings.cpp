/*

Source: https://leetcode.com/problems/isomorphic-strings/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  bool isIsomorphic(string s, string t) {

    char sCharPattern[256] = {};
    bool isPatternPresent[256] = {};
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      char sChar = s[i];
      char tChar = t[i];
      char sCharMapping = sCharPattern[sChar];

      if(sCharMapping != 0) {
        if(sCharMapping != tChar) {
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
};
