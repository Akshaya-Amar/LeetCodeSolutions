/*

Source: https://leetcode.com/problems/palindromic-substrings/

1st Approach (Brute force)

Basic Idea:
Create all possible subarrays and check if each subarray is palindrome or not

Time: O(n ^ 3), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {

public:
  int countSubstrings(string s) {

    int len = s.length();
    int count = 0;

    for(int i = 0; i < len; ++i) {

      for(int j = i + 1; j <= len; ++j) {

        if(isPalindrome(s.substr(i, j - i))) {
          ++count;
        }
      }
    }

    return count;
  }

private:
  bool isPalindrome(const string& sub) {

    int start = 0;
    int end = sub.length() - 1;

    while(start < end && sub[start] == sub[end]) {
      ++start;
      --end;
    }

    return start >= end;
  }
};

/*

Approach 2

Basic Idea:
Start from each index and treat each index as mid point and extend palindrome from that index for both odd and even lengths

Time: O(n ^ 2), where n is the length of the given String(s)
Space: O(1), in-place

*/

class Solution {

  int count;
  int len;

public:
  int countSubstrings(string s) {

    len = s.length();

    for(int i = 0; i < len; ++i) {
      extendPalindrome(s, i, i);
      extendPalindrome(s, i, i + 1);
    }

    return count;
  }

private:
  void extendPalindrome(const string& s, int start, int end) {

    while(start >= 0 && end < len && s[start] == s[end]) {
      ++count;
      --start;
      ++end;
    }
  }
};
