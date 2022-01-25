/*

Source: https://leetcode.com/problems/detect-capital/

Time: O(n), where n is the length of the given string(word)
Space: O(1), in-place

*/

class Solution {
public:
  bool detectCapitalUse(string word) {

    int len = word.length();
    bool isFirstLastCharCapital = (isLetterCapital(word[0]) && isLetterCapital(word[len - 1])) ? true : false;

    for(int i = 1; i < len; ++i) {

      if(isFirstLastCharCapital) {
        if(isLetterSmall(word[i])) {
          return false;
        }
      } else {
        if(isLetterCapital(word[i])) {
          return false;
        }
      }
    }

    return true;
  }

private:
  bool isLetterCapital(char ch) {
    return ch >= 'A' && ch <= 'Z';
  }

private:
  bool isLetterSmall(char ch) {
    return ch >= 'a' && ch <= 'z';
  }
};
