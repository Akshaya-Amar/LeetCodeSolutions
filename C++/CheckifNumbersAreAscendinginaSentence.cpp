/*

Source: https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

Time: O(n), where n is the length of the given string
Space: O(1), in-place

*/

class Solution {
public:
  bool areNumbersAscending(string s) {

    int prev = 0;
    int curr = 0;

    for(char ch : s) {

      if(isdigit(ch)) {

        curr = (curr * 10) + (ch - '0');

      } else if(curr != 0) {

        if(curr <= prev) {
          return false;
        }

        prev = curr;
        curr = 0;
      }
    }

    return (curr == 0) || (curr > prev);
  }
};
