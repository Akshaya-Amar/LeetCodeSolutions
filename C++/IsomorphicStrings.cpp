/*

Source: https://leetcode.com/problems/isomorphic-strings/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  bool isIsomorphic(string s, string t) {

    int sCharFreq[256] = {};
    int tCharFreq[256] = {};
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      char sChar = s[i];
      char tChar = t[i];

      if(sCharFreq[sChar] != tCharFreq[tChar]) {
        return false;
      }

      sCharFreq[sChar] = tCharFreq[tChar] = i + 1;
    }

    return true;

  }
};
