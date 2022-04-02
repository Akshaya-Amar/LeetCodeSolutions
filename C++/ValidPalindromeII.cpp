/*

Source: https://leetcode.com/problems/valid-palindrome-ii/

1st Approach (Two pointer approach)

Algorithm:
- Take 2 pointers; leftIndex and rightIndex
- Iterate through the string by incrementing the leftIndex and decrementing the rightIndex.
if the two characters on leftIndex and rightIndex are not equal, then delete the character(done using isCharacterDeleted = true).
- Now, iterate through rest of the remaining characters
if two characters are found which are not equal again, then return false
-return true after whole iteration of the string.

Time: O(n), where n is the length of the given string(s)
Space: O(1), constant space

*/

class Solution {
public:
  bool validPalindrome(string s) {
    return isPalindrome(s, 0, s.size() - 1, false);
  }

private:
  bool isPalindrome(string s, int leftIndex, int rightIndex, bool isCharDeleted) {

    while(leftIndex < rightIndex) {

      if(s[leftIndex] != s[rightIndex]) {

        if(isCharDeleted) {
          return false;
        }

        return isPalindrome(s, leftIndex + 1, rightIndex, true) || isPalindrome(s, leftIndex, rightIndex - 1, true);
      }

      ++leftIndex;
      --rightIndex;

    }

    return true;
  }
};

--------------------------------------------------------------------------------------------------------------------------

/*

2nd Approach(Same idea, but expanded form for better understanding)

Time: O(n), where n is the length of the given String(s)
Space: O(1), constant space

*/

class Solution {
public:
  bool validPalindrome(string s) {

    int leftIndex = 0;
    int rightIndex = s.length() - 1;

    while(leftIndex < rightIndex) {

      if(s[leftIndex] != s[rightIndex]) {
        return isPalindrome(s, leftIndex + 1, rightIndex) || isPalindrome(s, leftIndex, rightIndex - 1);
      }

      ++leftIndex;
      --rightIndex;
    }

    return true;
  }

private:
  bool isPalindrome(string s, int leftIndex, int rightIndex) {

    while(leftIndex < rightIndex) {

      if(s[leftIndex] != s[rightIndex]) {
        return false;
      }

      ++leftIndex;
      --rightIndex;
    }

    return true;
  }
};
