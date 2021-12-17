/*

Source: https://leetcode.com/problems/replace-all-digits-with-characters/

Time: O(n), where n is the length of the given string
Space: O(1), in-place, though we are using extra char array to assign desired character but,
we will still treat space as O(1) and not O(n) because we usually don't consider the output in the
space complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public String replaceDigits(String s) {

    char[] ch = s.toCharArray();
    int len = ch.length;

    for(int i = 1; i < len; i += 2) {
      ch[i] = shift(ch[i - 1], ch[i] - '0');
    }

    return String.valueOf(ch);
  }

  private char shift(char ch, int digit) {
    return (char)(ch + digit);
  }
}
