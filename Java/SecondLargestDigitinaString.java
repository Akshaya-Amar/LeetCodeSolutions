/*

Source: https://leetcode.com/problems/second-largest-digit-in-a-string/

2 Approaches

Time: O(n), where n is the size of the given string s
Space: O(n), char array is needed to check for the character if it's a digit

*/

class Solution {
  public int secondHighest(String s) {

    int max = -1;
    int secondMax = -1;

    for(char ch : s.toCharArray()) {

      if(isDigit(ch)) {

        int digit = ch - '0';

        if(digit > max) {
          secondMax = max;
          max = digit;
        } else if (digit > secondMax && digit < max) {
          secondMax = digit;
        }
      }
    }

    return secondMax;
  }

  private boolean isDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }
}

/*

2nd approach

Time: O(n), where n is the size of the given string s
Space: O(1), in-place

*/

class Solution {
  public int secondHighest(String s) {

    int max = -1;
    int secondMax = -1;
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      char ch = s.charAt(i);

      if(ch >= '0' && ch <= '9') {

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

  private boolean isDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }
}
