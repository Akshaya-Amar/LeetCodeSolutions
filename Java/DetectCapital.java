/*

Source: https://leetcode.com/problems/detect-capital/

Time: O(n), where n is the length of the given string(word)
Space: O(1), in-place

*/

class Solution {
  public boolean detectCapitalUse(String word) {

    int len = word.length();
    char[] ch = word.toCharArray();
    boolean isFirstLastCharCapital = (isLetterCapital(ch[0]) && isLetterCapital(ch[len - 1])) ? true : false;

    for(int i = 1; i < len; ++i) {

      if(isFirstLastCharCapital) {
        if(isLetterSmall(ch[i])) {
          return false;
        }
      } else {
        if(isLetterCapital(ch[i])) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isLetterCapital(char ch) {
    return ch >= 'A' && ch <= 'Z';
  }

  private boolean isLetterSmall(char ch) {
    return ch >= 'a' && ch <= 'z';
  }
}
