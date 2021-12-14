/*

Source: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

Time: O(n), where n is the length of the string(s1)
Space: O(1), in-place

*/

class Solution {
  public boolean areAlmostEqual(String s1, String s2) {

    char ch1 = '\u0000';
    char ch2 = '\u0000';
    int differElement = 0;
    int len = s1.length();

    for(int i = 0; i < len; ++i) {

      if(s1.charAt(i) != s2.charAt(i)) {

        if(++differElement == 1) {
          ch1 = s1.charAt(i);
          ch2 = s2.charAt(i);
        } else if(differElement == 2) {
          if(s1.charAt(i) != ch2 || s2.charAt(i) != ch1) {
            return false;
          }
        } else if (differElement == 3) {
          return false;
        }
      }
    }

    return differElement != 1;
  }
}
