/*

Source: https://leetcode.com/problems/capitalize-the-title/

Time: O(n), where n is the length of the given string(title)
Space: O(1), in-place though we are using char array but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public String capitalizeTitle(String title) {

    char[] ch = title.toCharArray();
    int len = ch.length;

    for(int i = 0; i < len; ++i) {

      int firstIndex = i;

      while(i < len && ch[i] != ' ') {
        ch[i] |= 32;
        ++i;
      }

      if(i - firstIndex > 2) {
        ch[firstIndex] &= ~32;
      }
    }

    return String.valueOf(ch);
  }
}
