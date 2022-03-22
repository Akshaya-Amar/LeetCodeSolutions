/*

Source: https://leetcode.com/problems/longest-palindromic-substring/

Approach 1 (Brute Force Approach, but will give TLE)

Time: O(n ^ 3), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {

  public String longestPalindrome(String s) {

    int maxLen = 0;
    int left = 0;
    int len = s.length();

    for(int i = 0; i < len; ++i) {

      for(int j = i; j < len; ++j) {

        String sub = s.substring(i, j + 1);
        if(isPalindrome(sub)) {
          int subLen = sub.length();
          if(subLen > maxLen) {
            left = i;
            maxLen = subLen;
          }
        }
      }
    }

    return s.substring(left, left + maxLen);
  }

  private boolean isPalindrome(String sub) {

    int start = 0;
    int end = sub.length() - 1;

    while(start < end && sub.charAt(start) == sub.charAt(end)) {
      ++start;
      --end;
    }

    return start >= end;
  }
}

/*

Approach 2 (Brute force too, but acceptable)

Time: O(n ^ 3), where n is the length of the given String(s)
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

            // no need to iterate unnecessary eg: "abba", longest can't be more than length 4(i.e. "abba" or "aabba")
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

/*

Approach 3

Time: O(n ^ 2), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {

  private int start;
  private int maxLen;
  private int len;

  public String longestPalindrome(String s) {

    len = s.length();

    for(int i = 0; i < len; ++i) {
      extendPalindrome(s, i, i);
      extendPalindrome(s, i, i + 1);
    }

    return s.substring(++start, start + maxLen);
  }

  private void extendPalindrome(String s, int left, int right) {

    while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }

    int subLen = right - left - 1;

    if(subLen > maxLen) {
      maxLen = subLen;
      start = left;
    }
  }
}
