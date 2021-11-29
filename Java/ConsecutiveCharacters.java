/*

Source: https://leetcode.com/problems/consecutive-characters/solution/

Time: O(n), where n is the length of the given string
Space: O(1), in-place

*/

class Solution {
  public int maxPower(String s) {

    int max = 1;
    int len = s.length();

    for(int i = 1; i < len; ++i) {

      if(s.charAt(i) == s.charAt(i - 1)) {

        char ch = s.charAt(i);
        int charCount = 2;

        while(++i < len && ch == s.charAt(i)) {
          ++charCount;
        }

        if(charCount > max) {
          max = charCount;
        }
      }
    }

    return max;
  }
}
