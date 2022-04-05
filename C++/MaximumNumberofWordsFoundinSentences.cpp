/*

Source: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/submissions/

Time: O(n * m), where n is the size of the given string array(sentences) and m is the average length of all sentences in array
Space: O(1), in-place

*/

class Solution {
public:
  int mostWordsFound(vector<string>& sentences) {

    int max = 0;
    for(string sentence : sentences) {

      int spaceCount = 1;
      int len = sentence.length();
      for(int i = 0; i < len; ++i) {
        if(sentence[i] == ' ') {
          ++spaceCount;
        }
      }

      if(spaceCount > max) {
        max = spaceCount;
      }
    }

    return max;
  }
};
