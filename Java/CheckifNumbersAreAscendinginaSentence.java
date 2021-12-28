/*

Source: https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

Time: O(n), where n is the length of the given string
Space: O(n), we need a char array(ch) of size equal to the length of the given string(s)

*/

class Solution {
  public boolean areNumbersAscending(String s) {

    int prev = 0;
    int curr = 0;

    for(char ch : s.toCharArray()) {

      if(isDigit(ch)) {

        curr = (curr * 10) + (ch - '0');

      } else if(curr != 0) {

        if(curr <= prev) {
          return false;
        }

        prev = curr;
        curr = 0;
      }
    }

    return curr == 0 || curr > prev;
  }

  private boolean isDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }
}
