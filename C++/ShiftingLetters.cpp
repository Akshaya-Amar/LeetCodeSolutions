/*

Source: https://leetcode.com/problems/shifting-letters/

Time: O(n), where n is the length of the given string(s)
Space: O(1)

*/

class Solution {
public:
  string shiftingLetters(string s, vector<int>& shifts) {

    int shift = 0;

    for(int i = s.size() - 1; i >= 0; --i) {
      shift += shifts[i] % 26;
      s[i] = ((s[i] - 'a') + shift) % 26 + 'a';
    }

    return s;
  }
};
