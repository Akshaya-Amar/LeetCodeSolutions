/*

Source: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences

Time: O(n), where n is the length of the given string
Space: O(1), i.e. in-place because though we are using array of size 26, but still it will be same for
all cases as the array size of 26 is fixed and doesn't depend on the input

*/

class Solution {
public:
  bool areOccurrencesEqual(string s) {

    int freq[26] = {};
    for(char ch : s) {
      ++freq[ch - 'a'];
    }

    int len = s.length();
    int numOfOccur = freq[s[0] - 'a'];
    for(int i = 1; i < len; ++i) {
      if(freq[s[i] - 'a'] != numOfOccur) {
        return false;
      }
    }

    return true;
  }
};
