/*

Source: https://leetcode.com/problems/valid-anagram/

2 Approaches

1st Approach

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place, thought we are using an array(charFreq) of size 26, but it doesn't depend on the input
and will be constant for all the inputs.

Basic Idea:
- Count the frequency of each character in the given string(String s)
- Now, iterate through each character present in another string(String t).
  If any character in String t is not present in String s
  eg:
  String s = "abc";
  String t = "bcz";
  Here, 'z' is not present in String s

  OR

  Count of some specific character in String t is more than those present in String s
  eg:
  String s = "aabc";
  String t = "aaab";
  Here, count of 'a' in String t is more than that present in String s

  then, return false.

- If second string(String t) was completely iterated without returning false, then return true;

*/

class Solution {
  public boolean isAnagram(String s, String t) {

    if(s.length() != t.length()) {
      return false;
    }

    int[] charFreq = new int[26];

    for(char sChar : s.toCharArray()) {
      ++charFreq[sChar - 'a'];
    }

    for(char tChar : t.toCharArray()) {
      if(--charFreq[tChar - 'a'] < 0) {
        return false;
      }
    }

    return true;
  }
}

/*

2nd Approach(Follow Up using Map)

Time: O(n), where n is the length of the given string(s)
Space: O(n), we need a map to store the characters(including unicode characters)

*/

class Solution {
  public boolean isAnagram(String s, String t) {

    if(s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> charFreq = new HashMap<>();
    for(char sChar : s.toCharArray()) {
      charFreq.put(sChar, charFreq.getOrDefault(sChar, 0) + 1);
    }

    for(char tChar : t.toCharArray()) {

      Integer val = charFreq.get(tChar);

      if(val == null || val == 0) {
        return false;
      }

      charFreq.put(tChar, val - 1);
    }

    return true;
  }
}
