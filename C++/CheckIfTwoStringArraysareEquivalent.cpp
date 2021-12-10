/*

Source: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

Time: O(n), where n is the number of characters present in the given string array
Space: O(1), in-place

*/

class Solution {
public:
  bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {

    int index1 = 0;
    int index2 = 0;
    int word1Index = 0;
    int word2Index = 0;
    string a = word1[0];
    string b = word2[0];
    int aSize = a.size();
    int bSize = b.size();
    int word1Size = word1.size();
    int word2Size = word2.size();

    while(word1Index < word1Size && word2Index < word2Size) {

      if(a[index1++] != b[index2++]) {
        return false;
      }

      if(index1 == aSize) {

        index1 = 0;

        if(++word1Index < word1Size) {
          a = word1[word1Index];
          aSize = a.size();
        }
      }

      if(index2 == bSize) {

        index2 = 0;

        if(++word2Index < word2Size) {
          b = word2[word2Index];
          bSize = b.size();
        }
      }
    }

    return word1Index == word1Size && word2Index == word2Size;
  }
};
