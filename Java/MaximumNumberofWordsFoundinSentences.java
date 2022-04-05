/*

Source: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/submissions/

Time: O(n * m), where n is the size of the given string array(sentences) and m is the average length of all sentences in array
Space: O(1), in-place

*/

class Solution {
  public int mostWordsFound(String[] sentences) {

    int max = 0;
    for(String sentence : sentences) {

      int spaceCount = 1;
      for(char ch : sentence.toCharArray()) {
        if(ch == ' ') {
          ++spaceCount;
        }
      }

      if(spaceCount > max) {
        max = spaceCount;
      }
    }

    return max;
  }
}
