/*

Source: https://leetcode.com/problems/second-largest-digit-in-a-string/

Time: O(n), where n is the size of the given string s
Space: O(1), in-place

*/

class Solution {
public:
  int secondHighest(string s) {

    int max = -1;
    int secondMax = -1;

    for(char ch : s) {

      if(isDigit(ch)) {

        int digit = ch - '0';

        if(digit > max) {
          secondMax = max;
          max = digit;
        } else if(digit > secondMax && digit < max) {
          secondMax = digit;
        }
      }
    }

    return secondMax;
  }
  
private:
  bool isDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }
};
