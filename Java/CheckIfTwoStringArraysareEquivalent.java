/*

Source: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

Time: O(n), where n is the number of characters present in the given string array
Space: O(1), in-place

*/

class Solution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

    int index1 = 0;
    int index2 = 0;
    int word1Index = 0;
    int word2Index = 0;
    String a = word1[0];
    String b = word2[0];
    int aLen = a.length();
    int bLen = b.length();
    int word1Len = word1.length;
    int word2Len = word2.length;

    while(word1Index < word1Len && word2Index < word2Len) {

      if(a.charAt(index1++) != b.charAt(index2++)) {
        return false;
      }

      if(index1 == aLen) {

        index1 = 0;

        if(++word1Index < word1Len) {
          a = word1[word1Index];
          aLen = a.length();
        }
      }

      if(index2 == bLen) {

        index2 = 0;

        if(++word2Index < word2Len) {
          b = word2[word2Index];
          bLen = b.length();
        }
      }
    }

    return word1Index == word1Len && word2Index == word2Len;
  }
}
