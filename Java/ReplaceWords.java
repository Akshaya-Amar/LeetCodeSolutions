/*

Source: https://leetcode.com/problems/replace-words/

Approach 1 (Brute force)
Time: O(m * n), where m is the length of the given string(sentence) and n is the length of list(dictionary)
Space: O(n), StringBuilder is needed to store the words

*/

class Solution {
  public String replaceWords(List<String> dictionary, String sentence) {

    String[] split = sentence.split(" ");

    StringBuilder res = new StringBuilder();

    for(String word : split) {

      for(String root : dictionary) {
        if(word.startsWith(root)) {
          word = root;
        }
      }

      if(res.length() != 0) {
        res.append(' ');
      }

      res.append(word);
    }

    return res.toString();
  }
}

/*

Approach 2 (Without using split())

Time: O(m * n), where m is the length of the given string(sentence) and n is the length of list(dictionary)
Space: O(n), StringBuilder is needed to store the words

*/

class Solution {
  public static String replaceWords(List<String> dictionary, String sentence) {

    StringBuilder res = new StringBuilder();
    char[] sentenceChars = sentence.toCharArray();
    int len = sentence.length();

    for(int i = 0; i < len; ++i) {

      int firstIndex = i;

      while(i < len && sentenceChars[i] != ' ') {
        ++i;
      }

      String word = String.valueOf(sentenceChars, firstIndex, i - firstIndex);

      for(String root : dictionary) {
        if(word.startsWith(root)) {
          word = root;
        }
      }

      if(res.length() != 0) {
        res.append(' ');
      }

      res.append(word);
    }

    return res.toString();
  }
}
