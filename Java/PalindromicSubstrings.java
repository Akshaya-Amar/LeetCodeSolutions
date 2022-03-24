/*

Source: https://leetcode.com/problems/palindromic-substrings/

1st Approach (Brute force)

Basic Idea:
Create all possible subarrays and check if each subarray is palindrome or not

Time: O(n ^ 3), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {

  public int countSubstrings(String s) {

    int len = s.length();
    int count = 0;

    for(int i = 0; i < len; ++i) {

      for(int j = i; j < len; ++j) {

        if(isPalindrome(s.substring(i, j + 1))) {
          ++count;
        }
      }
    }

    return count;
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

Approach 2

Basic Idea:
Start from each index and treat each index as mid point and extend palindrome from that index for both odd and even lengths

Time: O(n ^ 2), where n is the length of the given String(s)
Space: O(n), char array is needed access characters of String(s) and to avoid charAt() repeatidly

*/

class Solution {

  private int count;
  private int len;

  public int countSubstrings(String s) {

    char[] sChars = s.toCharArray();
    len = sChars.length;

    for(int i = 0; i < len; ++i) {
      extendPalindrome(sChars, i, i);
      extendPalindrome(sChars, i, i + 1);
    }

    return count;
  }

  private void extendPalindrome(char[] sChars, int start, int end) {

    while(start >= 0 && end < len && sChars[start] == sChars[end]) {
      ++count;
      --start;
      ++end;
    }
  }
}
