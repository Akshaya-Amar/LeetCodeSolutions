/*

Source: https://leetcode.com/problems/reverse-prefix-of-word/

Time: O(n), where n is the length of the given string(word)
Space: O(1), in-place, though we are using extra char array but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity
i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public String reversePrefix(String word, char ch) {

    char[] c = word.toCharArray();
    int len = c.length;

    for(int i = 0; i < len; ++i) {

      if(c[i] == ch) {
        return reverseSegment(c, 0, i);
      }
    }

    return word;
  }

  private String reverseSegment(char[] ch, int start, int end) {

    while(start < end) {
      char temp = ch[start];
      ch[start++] = ch[end];
      ch[end--] = temp;
    }

    return String.valueOf(ch);
  }
}
