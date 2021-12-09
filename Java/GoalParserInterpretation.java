/*

Source: https://leetcode.com/problems/goal-parser-interpretation/

Time: O(n), where n is the length of the given string
Space: O(1), in-place, though we are using extra string variable(res) to concatenate desired characters/string
but still we will treat space as (1) and not O(n), as we usually don't consider the output in the space
complexity i.e. temporary spaces used for getting the desired output are only considered.

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
