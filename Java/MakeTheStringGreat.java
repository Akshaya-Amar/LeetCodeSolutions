/*

Source: https://leetcode.com/problems/make-the-string-great/

Time: O(n), where n is the length of the given string(s)
Space: O(n), as we need a char array(ch) of size equal to the length of the given string(s)
*/

class Solution {
  public String makeGood(String s) {

    char[] ch = s.toCharArray();
    int j = 0;

    for(char c : ch) {

      if(j > 0 && (c ^ 32) == ch[j - 1]) {
        --j;
      } else {
        ch[j++] = c;
      }
    }

    return String.valueOf(ch, 0, j);
  }
}
