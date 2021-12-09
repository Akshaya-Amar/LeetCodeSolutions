/*

Source: https://leetcode.com/problems/goal-parser-interpretation/

Time: O(n), where n is the size of the given string
Space: O(1), in-place, though we are using extra string variable(res) to concatenate desired characters/string
but still we will treat space as (1) and not O(n), as we usually don't consider the output in the space
complexity

*/

class Solution {
public:
  string interpret(string s) {

    int size = s.size();
    string res;

    for(int i = 0; i < size;) {

      if(s[i] == '(') {
        if(s[i + 1] == ')') {
          res += 'o';
          i += 2;
        } else {
          res += "al";
          i += 4;
        }
      } else {
        res += 'G';
        i += 1;
      }
    }

    return res;
  }
};
