/*

Source: https://leetcode.com/problems/permutation-in-string/

Time: O(n * m), where n and m are the lengths of the given string s2 and total number lower case english letters(26) respectively
Space: O(n + k), we need char array for both the string i.e. s1 and s2

*/

class Solution {
  public boolean checkInclusion(String s1, String s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    char[] s1CharFreq = new char[26];
    char[] s2CharFreq = new char[26];
    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();

    for(int i = 0; i < s1Len; ++i) {
      ++s1CharFreq[s1Chars[i] - 'a'];
      ++s2CharFreq[s2Chars[i] - 'a'];
    }

    for(int i = s1Len; i < s2Len; ++i) {

      if(isPerm(s1CharFreq, s2CharFreq)) {
        return true;
      }

      ++s2CharFreq[s2Chars[i] - 'a'];
      --s2CharFreq[s2Chars[i - s1Len] - 'a'];
    }

    return isPerm(s1CharFreq, s2CharFreq);
  }

  private boolean isPerm(char[] s1CharFreq, char[] s2CharFreq) {

    for(int i = 0; i < 26; ++i) {
      if(s1CharFreq[i] != s2CharFreq[i]) {
        return false;
      }
    }

    return true;
  }
}
