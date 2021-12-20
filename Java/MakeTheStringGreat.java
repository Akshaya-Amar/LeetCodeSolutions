/*

Source:

Time: O(n), where n is the length of the given string(s)
Space: O(1)

*/

class Solution {
  public String makeGood(String s) {

    StringBuilder res = new StringBuilder(s.length());

    for(char ch : s.toCharArray()) {

      int len = res.length() - 1;

      if((len + 1) != 0 && (res.charAt(len) ^ 32) == ch) {
        res.deleteCharAt(len);
      } else {
        res.append(ch);
      }
    }

    return res.toString();
  }
}
