/*

Source: https://leetcode.com/problems/replace-all-digits-with-characters/

Time: O(n), where n is the length of the given string
Space: O(1), in-place

*/

class Solution {
public:
  string replaceDigits(string s) {

    int size = s.size();

    for(int i = 1; i < size; i += 2) {
      s[i] = shift(s, i);
    }

    return s;
  }

private:
  char shift(string s, int i) {
    return s[i - 1] + (s[i] - '0');
  }
};
