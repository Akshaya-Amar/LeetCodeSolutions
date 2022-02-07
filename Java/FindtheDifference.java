/*

Source: https://leetcode.com/problems/find-the-difference/

Time: O(n), where n is the length of the given string(s)
Space: O(n), char arrays for both strings(s and t) are needed to access char elements

*/

class Solution {
  public char findTheDifference(String s, String t) {

    int len = s.length();
    char addedLetter = t.charAt(len);

    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    for(int i = 0; i < len; ++i) {
      addedLetter ^= sChars[i] ^ tChars[i];
    }

    return addedLetter;
  }
}
