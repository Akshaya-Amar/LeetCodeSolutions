/*

Source: https://leetcode.com/problems/permutation-in-string/

Time: O(n + m), where n and m are the lengths of the given string s1 and string s2 respectively
Space: O(n + m), we need char array for both the string i.e. s1 and s2 

*/

class Solution {
  public boolean checkInclusion(String s1, String s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    char[] s1CharArray = s1.toCharArray();
    char[] s2CharArray = s2.toCharArray();

    char[] s1CharFreq = new char[26];
    for(int i = 0; i < s1Len; ++i) {
      ++s1CharFreq[s1CharArray[i] - 'a'];
    }

    int maxLen = s2Len - s1Len;
    for(int i = 0; i <= maxLen; ++i) {

      if(s1CharFreq[s2CharArray[i] - 'a'] != 0) {

        char[] s2CharFreq = new char[26];
        ++s2CharFreq[s2CharArray[i] - 'a'];

        int j;
        for(j = 1; j < s1Len; ++j) {

          int s2Char = s2CharArray[i + j] - 'a';

          if(s1CharFreq[s2Char] == 0) {
            break;
          } else {
            ++s2CharFreq[s2Char];
          }
        }

        if(j == s1Len && isPerm(s1CharFreq, s2CharFreq)) {
          return true;
        }
      }
    }

    return false;
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
