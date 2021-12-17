/*

Source: https://leetcode.com/problems/truncate-sentence/

Time: O(n), where n is the size of the given string
Space: O(1), in-place

*/

class Solution {
public:
  string truncateSentence(string s, int k) {

    int size = s.size();

    for(int i = 0; i < size; ++i) {

      if(s[i] == ' ') {
        if(--k == 0) {
          return s.substr(0, i);
        }
      }
    }

    return s;
  }
};
