/*

Source: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

Time: O(n), where n is the length of the given string(s)
Space: O(n), we need a char array(ch) of size equal to the length of the given string(s) to check whether the given character is 'a' or 'b'

*/

class Solution {
  public boolean checkString(String s) {

    int i = 0;
    int len = s.length();
    char[] ch = s.toCharArray();
    while(i < len && ch[i] == 'a') {
      ++i;
    }

    while(i < len) {
      if(ch[i] == 'a') {
        return false;
      }
      ++i;
    }

    return true;
  }
}
