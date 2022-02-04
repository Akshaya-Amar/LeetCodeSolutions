/*

Source: https://leetcode.com/problems/find-all-anagrams-in-a-string/

Time: O(n), where n is the length of the given string(s)
Space: O(n), list is needed to store the starting indices of anagrams

*/

class Solution {
  public List<Integer> findAnagrams(String s, String p) {

    int sLen = s.length();
    int pLen = p.length();

    if(sLen < pLen) {
      return new ArrayList<>();
    }

    char[] hash = new char[26];

    for(int i = 0; i < pLen; i++) {
      ++hash[p.charAt(i) - 'a'];
    }

    int left = 0;
    int right = 0;
    List<Integer> pos = new ArrayList<>();

    while(right < sLen) {

      int index = s.charAt(right) - 'a';

      if(hash[index] > 0) {
        --hash[index];
        ++right;
      } else {
        ++hash[s.charAt(left) - 'a'];
        ++left;
      }

      if(right - left == pLen) {
        pos.add(left);
      }
    }

    return pos;
  }
}
