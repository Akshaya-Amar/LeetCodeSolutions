/*

Source: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences

Time: O(n), where n is the length of the given string(s)
Space: O(n), as we need a char array of space equal to the length of the given string(s)

*/

class Solution {
  public boolean areOccurrencesEqual(String s) {

    char[] ch = s.toCharArray();
    int len = ch.length;
    int[] freq = new int[26];

    for(int i = 0; i < len; ++i) {
      ++freq[ch[i] - 'a'];
    }

    int numOfOccur = freq[s.charAt(0) - 'a'];
    for(int i = 1; i < len; ++i) {
      if(freq[ch[i] - 'a'] != numOfOccur) {
        return false;
      }
    }

    return true;
  }
}
