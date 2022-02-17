/*

Source: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

Time: O(m * n), where m is the length of the given string(s) and n is the length of the string(part)
Space: O(1), in-place

*/

class Solution {
  public String removeOccurrences(String s, String part) {

    int partLen = part.length();
    int index = s.indexOf(part);

    while(index != -1) {
      s = s.substring(0, index) + s.substring(index + partLen);
      index = s.indexOf(part);
    }

    return s;
  }
}
