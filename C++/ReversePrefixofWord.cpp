/*

Source: https://leetcode.com/problems/reverse-prefix-of-word/

Time: O(n), where n is the length of the given string(word)
Space: O(1), in-place

*/

class Solution {
public:
  string reversePrefix(string word, char ch) {

    int len = word.length();

    for(int i = 0; i < len; ++i) {

      if(word[i] == ch) {
        return reverseSegment(word, 0, i);
      }
    }

    return word;
  }

private:
  string reverseSegment(string word, int start, int end) {

    while(start < end) {
      char temp = word[start];
      word[start++] = word[end];
      word[end--] = temp;
    }

    return word;
  }
};
