/*

Source: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  bool checkString(string s) {

    int len = s.length();
    int i = 0;
    while(i < len && s[i] == 'a') {
      ++i;
    }

    while(i < len) {
      if(s[i] == 'a') {
        return false;
      }
      ++i;
    }

    return true;
  }
};
