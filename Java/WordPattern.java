/*

Source:

Time: O(n * m), where n is the length of the string(pattern) and m is the length of a longest word in string(s)
Space: O(n), we need a HashMap of size equal to the length of the given string(pattern)

*/

class Solution {
  public boolean wordPattern(String pattern, String s) {

    String[] words = s.split(" ");

    if(words.length != pattern.length()) {
      return false;
    }

    HashMap<Character, String> map = new HashMap<>();
    int len = words.length;

    for(int i = 0; i < len; ++i) {

      char ch = pattern.charAt(i);
      String word = words[i];
      String val = map.get(ch);

      if(val != null) {

        if(!val.equals(word)) {
          return false;
        }

      } else if(map.containsValue(word)) {
        return false;
      } else {
        map.put(ch, word);
      }
    }

    return true;
  }
}
