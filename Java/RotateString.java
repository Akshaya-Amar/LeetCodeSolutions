/*

Source: https://leetcode.com/problems/rotate-string/

Time: O(M * N), where M is the length of String s and N is the length of String goal
Space: O(1), in-place

*/

class Solution {
  public boolean rotateString(String s, String goal) {

    int sLen = s.length();
    int goalLen = goal.length();

    if(sLen != goalLen) {
      return false;
    }

    s = s + s;
    final char goalFirstChar = goal.charAt(0);

    for(int i = 0; i < goalLen; ++i) {

      if(s.charAt(i) == goalFirstChar) {

        int j = 0;

        while(++j < goalLen && s.charAt(i + j) == goal.charAt(j));

        if(j == goalLen) {
          return true;
        }
      }
    }

    return false;
  }
}
