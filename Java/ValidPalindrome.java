/*

Source: https://leetcode.com/problems/valid-palindrome/submissions/

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

*/

class Solution {
  public boolean isPalindrome(String s) {

    int head = 0;
    int tail = s.length() - 1;

    while(head < tail){

      char ch1 = s.charAt(head);
      while(head < tail && !(isAlphaNumeric(ch1))) {
        ch1 = s.charAt(++head);
      }

      char ch2 = s.charAt(tail);
      while(tail > head && !(isAlphaNumeric(ch2))) {
        ch2 = s.charAt(--tail);
      }

      if(ch1 != ch2 && ch1 != (ch2 ^ 32)) {
        return false;
      }

      ++head;
      --tail;
    }

    return true;
  }

  public boolean isAlphaNumeric(char ch){
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
  }
}
