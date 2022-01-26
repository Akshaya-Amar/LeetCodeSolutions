/*

Source: https://leetcode.com/problems/detect-capital/

Time: O(n), where n is the length of the given String(word)
Space: O(n), we need a char array(ch) of size equal to the length of the given String(word) to access each character

*/

class Solution {
  public boolean detectCapitalUse(String word) {

    int len = word.length();
    char[] ch = word.toCharArray();
    boolean isFirstLastCharCapital = isLetterCapital(ch[0]) && isLetterCapital(ch[len - 1]);

    for(int i = 1; i < len; ++i) {

      if(isFirstLastCharCapital) {
        if(!isLetterCapital(ch[i])) {
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
}
