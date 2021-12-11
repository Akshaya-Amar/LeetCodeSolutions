/*

Source: https://leetcode.com/problems/group-anagrams/

Time: O(n * m), where n is the length of the given string array(strs) and m is the maximum length of a string in the given string array(strs)
Space: O(n), we need a map for storing strings provided in the string array(strs) i.e. not an in-place

*/

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();

    for(String word : strs) {

      String key = generateKey(word);

      List<String> list = map.getOrDefault(key, new ArrayList<>());

      list.add(word);
      map.put(key, list);
    }

    return new ArrayList<>(map.values());
  }

  private String generateKey(String word) {

    char[] freq = new char[26];
    for(char ch : word.toCharArray()) {
      ++freq[ch - 'a'];
    }

    return String.valueOf(freq);
  }
}
