/*

Source: https://leetcode.com/problems/find-the-difference/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  char findTheDifference(string s, string t) {

    int len = s.length();
    char addedLetter = t[len];

    for(int i = 0; i < len; ++i) {
      addedLetter ^= s[i] ^ t[i];
    }

    return addedLetter;
  }
};
