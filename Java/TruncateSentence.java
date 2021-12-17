/*

Source: https://leetcode.com/problems/truncate-sentence/

Time: O(n), where n is the length of the given string
Space: O(1), in-place

*/

class Solution {
  public String truncateSentence(String s, int k) {

    for(int i = 0; i < s.length(); ++i) {
      if(s.charAt(i) == ' ') {
        if(--k == 0) {
          return s.substring(0, i);
        }
      }
    }

    return s;
  }
}
