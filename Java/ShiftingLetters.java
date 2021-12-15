/*

Source: https://leetcode.com/problems/shifting-letters/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place, though we are using an array to store corresponding values but we will still
treat space as O(1) and not O(n) because we usually don't consider the output in the space complexity
i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public String shiftingLetters(String s, int[] shifts) {

    char[] ch = s.toCharArray();
    int shift = 0;

    for(int i = ch.length - 1; i >= 0; --i) {
      shift += shifts[i] % 26;
      ch[i] = (char)(((ch[i] - 'a') + shift) % 26 + 'a');
    }

    return String.valueOf(ch);
  }
}
