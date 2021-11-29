/*

Source: https://leetcode.com/problems/consecutive-characters/solution/

Time: O(n), where n is the length of the given string
Space: O(1), in-place

*/

class Solution {
public:
  int maxPower(string s) {

    int max = 1;
    int len = s.size();

    for(int i = 1; i < len; ++i) {

      if(s[i] == s[i - 1]) {

        char ch = s[i];
        int charCount = 2;

        while(++i < len && ch == s[i]) {
          ++charCount;
        }

        if(charCount > max) {
          max = charCount;
        }
      }
    }

    return max;
  }
};
