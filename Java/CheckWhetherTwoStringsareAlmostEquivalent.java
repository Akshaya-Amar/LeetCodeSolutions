/*

Source: https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/

Time: O(n), where n is the length of the given string(word1)
Space: O(1), i.e. in-place because though we are using array(frequencies) of size 26, but still it will be same for
all the cases as the array size of 26 is fixed and doesn't depend on the input

*/

class Solution {
  public boolean checkAlmostEquivalent(String word1, String word2) {

    int[] frequencies = new int[26];
    int len = word1.length();

    for(int i = 0; i < len; ++i) {
      ++frequencies[word1.charAt(i) - 'a'];
      --frequencies[word2.charAt(i) - 'a'];
    }

    for(int freq : frequencies) {

      if(freq > 3 || freq < -3) {
        return false;
      }
    }

    return true;
  }
}
