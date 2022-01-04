/*

Source: https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/

Time: O(n), where n is the length of the given string(word1)
Space: O(1), i.e. in-place because though we are using array(frequencies) of size 26, but still it will be same for
all the cases as the array size of 26 is fixed and doesn't depend on the input

*/

class Solution {
public:
  bool checkAlmostEquivalent(string word1, string word2) {

    int freq[26] = {};
    int size = word1.length();

    for(int i = 0; i < size; ++i) {
      ++freq[word1[i] - 'a'];
      --freq[word2[i] - 'a'];
    }

    for(int f : freq) {

      if(f > 3 || f < -3) {
        return false;
      }
    }

    return true;
  }
};
