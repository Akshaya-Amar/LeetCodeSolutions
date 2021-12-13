/*

Source: https://leetcode.com/problems/goal-parser-interpretation/

Time: O(n), where n is the length of the given string
Space: O(1), in-place, though we are using extra StringBuilder(res) to append desired characters/string
but we will still treat space as O(1) and not O(n) because we usually don't consider the output in the space
complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public String interpret(String command) {

    int len = command.length();
    StringBuilder res = new StringBuilder(len);

    for(int i = 0; i < len;) {

      if(command.charAt(i) == '(') {
        if(command.charAt(i + 1) == ')') {
          res.append('o');
          i += 2;
        } else {
          res.append("al");
          i += 4;
        }
      } else {
        res.append('G');
        i += 1;
      }
    }

    res.trimToSize();

    return res.toString();
  }
}
