/*

Source: https://leetcode.com/problems/count-common-words-with-one-occurrence/

Time: O(n + m), where n and m are the lengths of the given string arrays words1 and words2 respectively
Space: O(n), as we need a map for storing the frequency of each string in the given string array(words1)

*/

class Solution {
  public int countWords(String[] words1, String[] words2) {

    Map<String, Integer> map = new HashMap<>();
    for(String word : words1) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    int count = 0;
    for(String word : words2) {

      Integer freq = map.get(word);

      if(freq != null && freq <= 1) {

        if(freq == 1) {
          ++count;
        } else if (freq == 0) {
          --count;
        }

        map.put(word, freq - 1);
      }
    }

    return count;
  }
}
