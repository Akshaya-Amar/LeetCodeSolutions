/*

Source: https://leetcode.com/problems/permutation-in-string/

Time: O(n * m), where n and m are the lengths of the given string s2 and total number lower case english letters(26) respectively
Space: O(1), in-place

*/

class Solution {
public:
  bool checkInclusion(string s1, string s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    vector<int> s1CharFreq(26, 0);
    vector<int> s2CharFreq(26, 0);
    for(int i = 0; i < s1Len; ++i) {
      ++s1CharFreq[s1[i] - 'a'];
      ++s2CharFreq[s2[i] - 'a'];
    }

    for(int i = s1Len; i < s2Len; ++i) {

      if(s1CharFreq == s2CharFreq) {
        return true;
      }

      ++s2CharFreq[s2[i] - 'a'];
      --s2CharFreq[s2[i - s1Len] - 'a'];
    }

    return s1CharFreq == s2CharFreq;
  }
};
