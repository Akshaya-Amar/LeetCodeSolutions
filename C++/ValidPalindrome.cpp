/*

Source: https://leetcode.com/problems/valid-palindrome/

*/

class Solution {
public:
  bool isPalindrome(string s) {

    int head = 0;
    int tail = s.size() - 1;

    while(head < tail){

      char ch1 = s[head];
      while(head < tail && !(isAlphaNumeric(ch1))) {
        ch1 = s[++head];
      }

      char ch2 = s[tail];
      while(tail > head && !(isAlphaNumeric(ch2))) {
        ch2 = s[--tail];
      }

      if(ch1 != ch2 && ch1 != (ch2 ^ 32)) {
        return false;
      }

      ++head;
      --tail;
    }

    return true;
  }

private:
  bool isAlphaNumeric(char ch){
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
  }
};
