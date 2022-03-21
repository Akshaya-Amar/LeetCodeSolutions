/*

Source: https://leetcode.com/problems/longest-palindromic-substring/

Time: O(n ^ 2), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {
  public String longestPalindrome(String s) {

    int maxLen = 0;
    String longestSub = String.valueOf(s.charAt(0));
    int len = s.length();

    outer:
    for(int i = 0; i < len; ++i) {

      for(int j = len - 1; j > i; --j) {

        while(j > i && s.charAt(i) != s.charAt(j)) {
          --j;
        }

        int x = i;
        int y = j;

        while(x < y && s.charAt(x) == s.charAt(y)) {
          ++x;
          --y;
        }

        // to check whether the substring is palindrome or not, where x == y is for odd length and x > y is for even length
        if(x >= y) {

          // if length of palindrome substring is more than previous palindrome string, then make this substring as max
          if(j - i > maxLen) {

            maxLen = j - i;
            longestSub = s.substring(i, j + 1);

            // no need to iterate unnecessary eg: "abba", longest can't be more than len 4(i.e. "abba" or "aabba")
            if(longestSub.length() + i == len) {
              break outer;
            }
          }
        }
      }
    }

    return longestSub;
  }
}
