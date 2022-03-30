/*

Source: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

4 Approaches

Basic Idea:
Just return the max digit
eg:
n = 1234 (take as many 1's as the value of digits i.e. take 1 1's for digit 1, take 3 1's for digit 3, take 4 1's for digit 4 and so on)
    1111
  + 0111
  + 0011
  + 0001
    ----
    1234
    ----

1st Approach

Time: O(n), where n is the length of the given string(n)
Space: O(1), in-place

*/

class Solution {
  public int minPartitions(String n) {

    int max = 0;
    int len = n.length();

    for(int i = 0; i < len; ++i) {

      int digit = n.charAt(i) - '0';

      if(digit > max) {
        max = digit;
      }
    }

    return max;
  }
}

/*

2nd Approach (avoid charAt() repeatidly)

Time: O(n), where n is the length of the given string(n)
Space: O(n), char array is needed to access each character of the given string(s)

*/

class Solution {
  public int minPartitions(String n) {

    int max = 0;

    for(char ch : n.toCharArray()) {

      int digit = ch - '0';

      if(digit > max) {
        max = digit;
      }
    }

    return max;
  }
}

/*

3rd Approach (faster than Approach 2, by avoiding char('8') to digit(8) conversion repeatidly i.e. avoiding int digit = ch - '0')

Time: O(n), where n is the length of the given string(n)
Space: O(n), char array is needed to access each character of the given string(s)

*/

class Solution {
  public int minPartitions(String n) {

    int max = 48; // 48 is the ASCII value of 0(zero)

    for(char ch : n.toCharArray()) {

      if(ch > max) {
        max = ch;
      }
    }

    return max - 48; // subtract the 48(ASCII value of 0(zero)) from the max
    // eg: if max digit in the string(n) is 8, then max will be 56(which is the ASCII value of 8) and 56 - 48 = 8 which will be desired output
  }
}

/*

4th Approach(1 Liner)

*/

class Solution {
  public int minPartitions(String n) {
    return Character.getNumericValue(n.chars().max().getAsInt());
  }
}
